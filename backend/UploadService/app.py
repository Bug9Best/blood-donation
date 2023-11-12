from curses import flash
from flask import Flask, request
from google.cloud import storage
import uuid
import os
import py_eureka_client.eureka_client as eureka_client

port = 8080

app = Flask(__name__)

os.environ["GOOGLE_APPLICATION_CREDENTIALS"] = r"env/keys.json"

storage_client = storage.Client()
bucket = storage_client.bucket("sop_project")

eureka_client.init(
    eureka_server="http://localhost:8761/eureka/",
    app_name="api-upload",
    instance_port=port,
)

@app.route("/")
def index():
    return "Hello, Flask!"


@app.route("/upload-file/", methods=["POST"])
def upload_file():
    if "file" not in request.files:
        return "No file part"
    file = request.files["file"]
    path = str(uuid.uuid4())
    blob = bucket.blob(path)
    blob.upload_from_file(file)
    return {"fileName": file.filename, "filePath": blob.public_url, "imageId": path}


@app.route("/delete-file/<imageId>", methods=["DELETE"])
def delete_file(imageId):
    try:
        blob = bucket.blob(imageId)
        blob.delete()
        return {"message": "success"}
    except Exception as e:
        return {"message": "File not found"}, 404


if __name__ == "__main__":
    app.run(debug=True, port=port)

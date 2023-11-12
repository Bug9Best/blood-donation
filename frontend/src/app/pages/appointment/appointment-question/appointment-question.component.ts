import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import question from 'src/app/data/question.json';

@Component({
  selector: 'appointment-question',
  templateUrl: './appointment-question.component.html',
  styleUrls: ['./appointment-question.component.scss']
})
export class AppointmentQuestionComponent {
  disableNext: boolean = true;
  selectedAnswer: number = -1;
  listQuestion: any[] = question;
  @Input() currentQuestion: number = 0;

  @Output() onChangeQuestion: EventEmitter<any> = new EventEmitter<any>();
  @Output() onCancelQuestion: EventEmitter<any> = new EventEmitter<any>();
  @Output() onFinishQuestion: EventEmitter<any> = new EventEmitter<any>();

  constructor(
    private confirmationService: ConfirmationService
  ) { }

  chooseAnswer(item: any, answer: number) {
    this.selectedAnswer = answer;
    if (item.concern === answer) {
      this.disableNext = true;
      this.confirmationService.confirm({
        header: 'โปรดทราบ!',
        icon: 'pi pi-exclamation-triangle',
        message: item.concern_text,
        acceptLabel: 'รับทราบและดำเนินการต่อ',
        rejectLabel: 'กลับหน้าแรก',
        rejectIcon: 'pi pi-timess',
        reject: () => {
          this.onCancelQuestion.emit();
        }
      })
    }
    else {
      this.disableNext = false;
    }
  }

  resetValue() {
    this.disableNext = true;
    this.selectedAnswer = -1;
  }

  changeQuestion(method: string) {
    this.resetValue();
    if (method === 'next') {
      this.onChangeQuestion.emit(this.currentQuestion + 1);
    }
    else if (method === 'finish') {
      this.onFinishQuestion.emit();
    }
    else {
      if (this.currentQuestion > 0) {
        this.onChangeQuestion.emit(this.currentQuestion - 1);
      }
      else {
        this.onCancelQuestion.emit();
      }
    }
  }
}

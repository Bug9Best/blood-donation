import { Component } from '@angular/core';
import { MessageService } from 'primeng/api';

export enum StepAppoint {
  Defalut = 0,
  Question = 1,
  Appointment = 2,
}

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.scss']
})
export class AppointmentComponent {
  curretstep: StepAppoint = StepAppoint.Defalut;
  currentQuestion: number = 0;

  constructor(
    private messageService: MessageService,
  ) { }

  showMessages(severity: string, summary: string, detail: string) {
    this.messageService.add({
      severity: severity,
      summary: summary,
      detail: detail
    });
  }

  cancelQuestion() {
    this.currentQuestion = 0;
    this.curretstep = StepAppoint.Defalut;
  }

  toQuestion() {
    this.curretstep = StepAppoint.Question;
  }

  toAppointment() {
    this.currentQuestion = 0;
    this.curretstep = StepAppoint.Appointment;
  }

  showQuestion(value: number) {
    this.currentQuestion = value;
  }

  createAppointment(value: any) {
    this.showMessages('success', 'Agendamento', 'Agendamento realizado com sucesso!');
  }
}

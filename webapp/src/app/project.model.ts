export interface LoginData {
  login: string;
  password: string;
}

export interface User {
  userId: number;
  firstName: string;
  lastName: string;
  login: string;
  payoutAmount: number;
}

export interface RegisterData {
  firstName: string;
  lastName: string;
  login: string;
  password: string;
  payoutAmount: number;
}

export interface Payment {
  id: number;
  note: string;
  realizationDate: Date;
  amount: number;
  type: string;
}

export interface PaymentType {
  id: number;
  name: string;
}

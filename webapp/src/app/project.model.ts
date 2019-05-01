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

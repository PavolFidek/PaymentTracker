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
  login: string;
  password: string;
}

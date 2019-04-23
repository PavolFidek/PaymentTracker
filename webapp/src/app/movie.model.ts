export class Movie {

  constructor(public id ?: string,
              public title?: string,
              public notes?: string,
              public year?: number,
              public key?: string,
              public director?: string,
              public cast?: string,
              public genre?: string) {
  }
}

export interface User {
  userId: number;
  firstName: string;
  lastName: string;
  login: string;
  payoutAmount: number;
}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ProjectService } from 'app/project.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.scss']
})
export class RegisterUserComponent implements OnInit {
  public registerForm: FormGroup;

  constructor(
    private projectService: ProjectService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { }

  ngOnInit() {
    this.setForm();
  }

  setForm() {
    this.registerForm = this.formBuilder.group({
      firstName: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      lastName: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      payoutAmount: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      login: new FormControl('', Validators.compose([
        Validators.required,
      ])),
      password: new FormControl('', Validators.compose([
        Validators.required,
        Validators.minLength(8)
      ]))
    })
  }

  register() {
    if (this.registerForm.valid) {
      this.projectService.registerUser(this.registerForm.value)
      .subscribe(res => {
        // registred
        if (res.id !== -1) {
          this.goLoginPage();
        } else {
          alert('User with given login exist already');
        }
      },
      error => {
        alert(error);
      })
    } else {
      this.registerForm.controls.firstName.markAsDirty({ onlySelf: true });
      this.registerForm.controls.lastName.markAsDirty({ onlySelf: true });
      this.registerForm.controls.payoutAmount.markAsDirty({ onlySelf: true });
      this.registerForm.controls.login.markAsDirty({ onlySelf: true });
      this.registerForm.controls.password.markAsDirty({ onlySelf: true });
    }
  }

  goLoginPage() {
    this.router.navigate(['/userLogin']);
  }
}

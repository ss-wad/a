# Angular Authentication App Setup

## Step 1: Install Angular CLI and Create Project

Open your terminal and run the following commands:

**1. Install Angular CLI globally**
```bash
npm install -g @angular/cli
```

**2. Create a new Angular project named `ass3`**
```bash
ng new ass3
```

**3. Navigate into your project folder**
```bash
cd ass3
```

**4. Generate components (Register, Login, Profile)**
```bash
ng generate component register
ng generate component login
ng generate component profile
```

---

## Step 2: Configure Routing
Open `src/app/app.routes.ts` and replace its contents with:

```typescript
import { Routes } from '@angular/router';
import { Register } from './register/register';
import { Login } from './login/login';
import { Profile } from './profile/profile';

export const routes: Routes = [
  { path: '', redirectTo: 'register', pathMatch: 'full' },
  { path: 'register', component: Register },
  { path: 'login', component: Login },
  { path: 'profile', component: Profile }
];
```

---

## Step 3: Configure the Root Application Component
**1. Open `src/app/app.html`** and replace the content with:
```html
<router-outlet></router-outlet>
```

**2. Open `src/app/app.ts`** and replace the content with:
```typescript
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.html'
})
export class App {}
```

---

## Step 4: Register Component
**1. Open `src/app/register/register.ts`** and replace the content with:
```typescript
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './register.html'
})
export class Register {
  user = {
    name: '',
    email: '',
    password: ''
  };

  constructor(private router: Router) {}

  register() {
    const newUser = {
      name: this.user.name,
      email: this.user.email,
      password: this.user.password
    };
    let existingUsers = JSON.parse(localStorage.getItem('users') || '[]');
    existingUsers.push(newUser);
    localStorage.setItem('users', JSON.stringify(existingUsers));
    console.log('User registered:', newUser);
    this.router.navigate(['/login']);
  }
}
```

**2. Open `src/app/register/register.html`** and replace the content with:
```html
<h2>Register</h2>

<input [(ngModel)]="user.name" placeholder="Name"><br><br>
<input [(ngModel)]="user.email" placeholder="Email"><br><br>
<input [(ngModel)]="user.password" type="password" placeholder="Password"><br><br>

<button (click)="register()">Register</button>

<br><br>
<a routerLink="/login">Login</a>
```

---

## Step 5: Login Component
**1. Open `src/app/login/login.ts`** and replace the content with:
```typescript
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './login.html'
})
export class Login {
  email = '';
  password = '';

  constructor(private router: Router) {}

  login() {
    let users = JSON.parse(localStorage.getItem('users') || '[]');
    let found = users.find(
      (u: any) => u.email === this.email && u.password === this.password
    );
    if (found) {
      localStorage.setItem('currentUser', JSON.stringify(found));
      console.log('Login successful:', found);
      this.router.navigate(['/profile']);
    } else {
      console.log('Login failed: Invalid email or password');
    }
  }
}
```

**2. Open `src/app/login/login.html`** and replace the content with:
```html
<h2>Login</h2>

<input [(ngModel)]="email" placeholder="Email"><br><br>
<input [(ngModel)]="password" type="password" placeholder="Password"><br><br>

<button (click)="login()">Login</button>

<br><br>
<a routerLink="/register">Register</a>
```

---

## Step 6: Profile Component
**1. Open `src/app/profile/profile.ts`** and replace the content with:
```typescript
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [],
  templateUrl: './profile.html'
})
export class Profile {
  user = JSON.parse(localStorage.getItem('currentUser') || '{}');

  constructor(private router: Router) {}

  logout() {
    this.router.navigate(['/login']);
  }
}
```

**2. Open `src/app/profile/profile.html`** and replace the content with:
```html
<h2>Profile</h2>

<p>Name: {{ user.name }}</p>
<p>Email: {{ user.email }}</p>

<button (click)="logout()">Logout</button>
```

---

## Step 7: Run Application
Open your terminal inside the `ass3` project folder and run:

```bash
ng serve
```

Open your browser and naturally navigate to [http://localhost:4200](http://localhost:4200).
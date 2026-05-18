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

## Step 2: Configure the Root Application Component
**1. Open `src/app/app.html`** and replace the content with:
```html
<h2>{{title()}}</h2>
<input type="text" placeholder="name" #name>
<input type="email" placeholder="email" #email>

<button (click)="getValues(name.value, email.value)">register</button>


<h2>registered users</h2>
<p>Name: {{displayName}}</p>
<p>Email: {{displayEmail}}</p>  
```

**2. Open `src/app/app.ts`** and replace the content with:
```typescript
import { Component, signal } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('title');
  displayName='';
  displayEmail='';
  getValues(name: string, email: string) {
    this.displayName = name;
    this.displayEmail = email;
  }

}
```

## Step 3: Run Application
Open your terminal inside the `ass3` project folder and run:

```bash
ng serve
```

Open your browser and naturally navigate to [http://localhost:4200](http://localhost:4200).

# Node.js & Express Dashboard Setup

## Step 1: Create Project Structure
In your assignment folder:
1. Create a file named `server.js`.
2. Create a folder named `public`.
3. Inside the `public` folder, create a file named `index.html`.

## Step 2: Add Code to `server.js`
Copy this code into your `server.js` file:
```javascript
const express = require('express');
const app = express();
const path = require('path');

// Serve files from a folder named "public"
app.use(express.static('public'));

// Fallback to send index.html for the root route
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.listen(3000, () => {
    console.log('Server running at http://localhost:3000');
});
```

## Step 3: Add Code to `public/index.html`
Copy this code into your `public/index.html` file:
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Served by Node</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .sidebar { min-height: 100vh; background: #212529; color: white; }
        .sidebar a { color: white; text-decoration: none; padding: 10px 20px; display: block; }
        .sidebar a:hover { background: #343a40; }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block sidebar p-0">
            <div class="p-3"><h4>Admin Panel</h4></div>
            <ul class="nav flex-column">
                <li><a href="#">Dashboard</a></li>
                <li><a href="#">Orders</a></li>
                <li><a href="#">Products</a></li>
                <li><a href="#">Customers</a></li>
            </ul>
        </nav>

        <main class="col-md-10 ms-sm-auto px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">E-commerce Stats (via Node.js)</h1>
            </div>

            <div class="row">
                <div class="col-md-3 mb-4">
                    <div class="card bg-primary text-white shadow">
                        <div class="card-body">
                            <h5>Total Sales</h5>
                            <h3>$24,500</h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 mb-4">
                    <div class="card bg-success text-white shadow">
                        <div class="card-body">
                            <h5>New Orders</h5>
                            <h3>150</h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 mb-4">
                    <div class="card bg-warning text-dark shadow">
                        <div class="card-body">
                            <h5>Total Users</h5>
                            <h3>1,205</h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 mb-4">
                    <div class="card bg-danger text-white shadow">
                        <div class="card-body">
                            <h5>Returns</h5>
                            <h3>12</h3>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```

## Step 4: Initialize and Run
Open your terminal inside the project folder and run these commands in order:

**1. Initialize Node.js project**
```bash
npm init -y
```

**2. Install Express framework**
```bash
npm install express
```

**3. Start the server**
```bash
node server.js
```

Once running, you can view your dashboard at [http://localhost:3000](http://localhost:3000).

# Node.js, Express & MongoDB Dashboard Setup

## Step 1: Create Project Structure
In your assignment folder, create the following files and folders:
1. Create a file named `server.js`.
2. Create a file named `.env`.
3. Create a folder named `public`.
4. Inside the `public` folder, create a file named `index.html`.

## Step 2: Add Configuration (`.env`)
Copy this code into your `.env` file and make sure your MongoDB Compass/Cluster is connected:
```env
MONGO_URI=mongodb://localhost:27017
```

## Step 3: Add Code to `server.js`
Copy this code into your `server.js` file:
```javascript
require('dotenv').config(); // Load environment variables
const express = require('express');
const mongoose = require('mongoose');
const path = require('path');
const app = express();

app.use(express.json());
app.use(express.static('public'));

// Use the key from the .env file
const dbURI = process.env.MONGO_URI;

mongoose.connect(dbURI)
    .then(() => console.log("✅ MongoDB Connected"))
    .catch(err => console.error("❌ Connection Error:", err));

const User = mongoose.model('User', { name: String, email: String });

// CRUD Routes
app.post('/api/users', async (req, res) => {
    const user = await User.create(req.body);
    res.send(user);
});

app.get('/api/users', async (req, res) => {
    const users = await User.find();
    res.send(users);
});

app.put('/api/users/:id', async (req, res) => {
    const user = await User.findByIdAndUpdate(req.params.id, req.body, { new: true });
    res.send(user);
});

app.delete('/api/users/:id', async (req, res) => {
    await User.findByIdAndDelete(req.params.id);
    res.send({ message: "Deleted" });
});

app.listen(3000, () => console.log(' Server: http://localhost:3000'));
```

## Step 4: Add Code to `public/index.html`
Copy this code into your `public/index.html` file:
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        /* Sidebar styling for desktop */
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
                <h1 class="h2">E-commerce Stats</h1>
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
            
            <p class="mt-4">Welcome back, Admin. Here is your daily overview.</p>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```

## Step 5: Install Dependencies & Run
Open your terminal inside the project folder and run these commands in order:

**1. Initialize Node.js project**
```bash
npm init -y
```

**2. Install required packages (Express, Mongoose, Dotenv)**
```bash
npm install express mongoose dotenv
```

**3. Start the server**
```bash
node server.js
```

You can view your dashboard at [http://localhost:3000](http://localhost:3000).

## Step 6: Test the API with Postman

### CREATE (POST) Request

1. Open Postman and create a new **POST** request to `http://localhost:3000/api/users`.
2. In the "**Body**" tab, select **raw** and set the format to **JSON**.
3. Paste the following data:
```json
{ 
    "name": "abc Singh", 
    "email": "abc@ait.edu" 
}
```
4. Click **Send**. You should see the user returned with an `_id` confirming it was saved in your database.

### READ (GET) Request
1. Create a new **GET** request to `http://localhost:3000/api/users`.
2. Click **Send**. You should see a list of all users in the response.
3. *Note: You can also append a specific user ID to the URL (e.g., `http://localhost:3000/api/users/<user_id>`) to get a single user.*

###  UPDATE (PUT) Request
1. Create a new **PUT** request to `http://localhost:3000/api/users/<user_id>`.
2. In the "**Body**" tab, select **raw** and set the format to **JSON**.
3. Paste the updated data:
```json
{ 
    "name": "abc Singh Updated", 
    "email": "new_abc@ait.edu" 
}
```
4. Click **Send**. You should see the updated user details.

### DELETE Request
1. Create a new **DELETE** request to `http://localhost:3000/api/users/<user_id>`.
2. Click **Send**. You should get a success message confirming the user was deleted.


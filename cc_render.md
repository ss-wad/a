# Deploy Node.js App to Render

## 1. Prepare Your Project
Make sure your project is pushed to GitHub 
COPY ITS URL 

## 2. Connect to Render
1. Go to the [Render Dashboard](https://dashboard.render.com/) and log in.
2. Click **New +** at the top right and select **Web Service**.
3. Under "Public GitHub Repo", enter your url.

## 3. Configure Deployment
On the configuration page, fill in the following:
* **Name**: Choose a name for your application.
* **Region**: Leave as default (or pick closest).
* **Branch**: Select your main branch (e.g., `main` or `master`).
* **Environment**: Select **Node**.
* **Build Command**: `npm install`
* **Start Command**: `npm start` (or `node server.js`)
* **Instance Type**: Select the **Free** tier (or paid if preferred).

## 4. Deploy
1. Scroll down and click **Create Web Service**.
2. Render will automatically install dependencies and start your server.
3. Wait for the deploy logs to say **Live**.

## 5. View Your Site
Click the generated URL (e.g., `https://your-app-name.onrender.com`) near the top-left of the service page to view your live Node.js application!
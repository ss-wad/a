# GitHub Version Control Setup Guide

## Step 1: Account Creation
1. Go to [GitHub.com](https://github.com).
2. Sign up using your email and verify your account.

## Step 2: Create a Remote Repository
1. Click the **+** icon in the top right corner and select **New repository**.
2. Give it a name (e.g., `my-assignment-repo`).
3. Set it to **Public** and click **Create repository**.
4. Copy the Repository URL (it looks like `https://github.com/username/repo-name.git`).

## Step 3: Local Project Setup
1. Create a new folder on your computer (e.g., `my-assignment`).
2. Open this folder in VS Code.
3. Create a new text file inside the folder (e.g., `readme.txt`).
4. Write some content in the file and save it.
5. Open the integrated terminal in VS Code (`Ctrl` + `` ` `` or **Terminal > New Terminal**).

## Step 4: Git Commands to Push Code
Run these commands in your VS Code terminal in order:

**1. Initialize a local Git repository**
```bash
git init
```

**2. Add all files in the folder to the staging area**
```bash
git add .
```

**3. Record your changes with a message**
```bash
git commit -m "Initial commit"
```

**4. Rename the default branch to 'main'**
```bash
git branch -M main
```

**5. Link your local folder to the GitHub repo**
```bash
git remote add origin YOUR_URL
```

**6. Push your code to GitHub**
```bash
git push -u origin main
```

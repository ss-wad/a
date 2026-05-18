# Virtual Machine Setup and File Transfer (VirtualBox)

Follow these steps to set up two Ubuntu Virtual Machines in VirtualBox and transfer files between them.

## 1. Network Configuration
1. Open **VirtualBox**.
2. Go to **Network** (or **File > Preferences > Network** in older versions).
3. Click the **+** (Add) icon to create a new **NAT Network**.
4. Click **OK**.

## 2. Create Virtual Machines
### Create VM1
1. Click **New** and name the machine `VM1`.
2. Type: **Linux**, Version: **Ubuntu (64-bit)**.
3. Click **Next** until you reach the Hard Disk section.
4. Select **Use an existing virtual hard disk file**.
5. Select your downloaded Ubuntu ISO/image file, open it, and click **Create**.

### Create VM2
1. Repeat the exact same steps above, but name this machine `VM2`.

## 3. Attach VMs to the NAT Network
1. Right-click **VM1** -> **Settings** -> **Network**.
2. Change **Attached to** to **NAT Network**.
3. Select the NAT network you created earlier.
4. *(Optional)* Under Advanced, if you see **Promiscuous Mode**, set it to **Allow All**.
5. Click **OK**.
6. **Repeat** these steps for **VM2**.

## 4. Boot and Login
1. Double-click both **VM1** and **VM2** to start them.
2. Login credentials for both:
   - **Username:** `vagrant`
   - **Password:** `vagrant`

## 5. Install Dependencies and Check IPs
Run the following commands in the terminals of **both VM1 and VM2**:

```bash
sudo apt update
sudo apt install net-tools
```

Check the IP address on both VMs:
```bash
ifconfig
```
*(Note down the IP address of VM2, you will need it later).*

## 6. Create a File on VM1
In the terminal for **VM1**, run:

```bash
touch transfer.txt
nano transfer.txt
```
* Write some text in the file.
* Save the file: Press `Ctrl + O`, then `Enter`.
* Exit Nano: Press `Ctrl + X`.

You can verify the file is created by running:
```bash
ls
cat transfer.txt
```

## 7. Transfer File from VM1 to VM2
In the terminal for **VM1**, use the `scp` command to transfer the file to VM2. Replace `IP_OF_VM2` with the actual IP address you noted earlier:

```bash
scp transfer.txt vagrant@IP_OF_VM2:/home/vagrant
```
* If prompted to continue connecting, type `yes` and press Enter.
* When prompted for a password, type `vagrant` and press Enter.

## 8. Verify the File on VM2
In the terminal for **VM2**, check if the file arrived:

```bash
ls
```
You should see `transfer.txt` in the output. Read its contents to confirm:

```bash
cat transfer.txt
```
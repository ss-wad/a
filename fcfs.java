package org.cloudbus.cloudsim.examples;

import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

import java.util.*;

public class FCFS_SJF {

    public static DatacenterBroker broker;
    private static List<Cloudlet> cloudletList;
    private static List<Vm> vmlist;

    public static void main(String[] args) {

        Log.printLine("Starting FCFS_SJF...");

        try {
            int num_user = 1;
            Calendar calendar = Calendar.getInstance();
            boolean trace_flag = false;

            CloudSim.init(num_user, calendar, trace_flag);

            Datacenter datacenter0 = createDatacenter("Datacenter_0");

            broker = new DatacenterBroker("Broker");
            int brokerId = broker.getId();

            vmlist = new ArrayList<>();

            int vmid = 0; 
            int mips = 250;
            long size = 10000;
            int ram = 512;
            long bw = 1000;
            int pesNumber = 1;
            String vmm = "Xen";

           
            Vm vm1 = new Vm(
                    vmid,
                    brokerId,
                    mips,
                    pesNumber,
                    ram,
                    bw,
                    size,
                    vmm,
                    new CloudletSchedulerTimeShared()
            );

            vmlist.add(vm1);

            broker.submitVmList(vmlist);

            cloudletList = new ArrayList<>();

            long lengths[] = {4000, 2000, 3000};

            // Uncomment for SJF
            Arrays.sort(lengths);

            long fileSize = 300;
            long outputSize = 300;

            UtilizationModel utilizationModel = new UtilizationModelFull();

            for (int i = 0; i < lengths.length; i++) {

                // Fixed: Added 'i' as the cloudletId
                Cloudlet cloudlet = new Cloudlet(
                        i, 
                        lengths[i],
                        pesNumber,
                        fileSize,
                        outputSize,
                        utilizationModel,
                        utilizationModel,
                        utilizationModel
                );

                cloudlet.setUserId(brokerId);
                cloudletList.add(cloudlet);
            }

            broker.submitCloudletList(cloudletList);

            CloudSim.startSimulation();

            List<Cloudlet> newList = broker.getCloudletReceivedList();

            CloudSim.stopSimulation();

            printCloudletList(newList);

            Log.printLine("FCFS_SJF finished!"); 

        } catch (Exception e) {
            e.printStackTrace();
            Log.printLine("Simulation terminated due to an error");
        }
    }

    private static Datacenter createDatacenter(String name) {

        List<Host> hostList = new ArrayList<>();
        List<Pe> peList = new ArrayList<>();

        int mips = 1000;

        peList.add(new Pe(0, new PeProvisionerSimple(mips))); 

        int ram = 2048;
        long storage = 1000000;
        int bw = 10000;

        hostList.add(
                new Host(
                        0, 
                        new RamProvisionerSimple(ram),
                        new BwProvisionerSimple(bw),
                        storage,
                        peList,
                        new VmSchedulerTimeShared(peList)
                )
        );

        String arch = "x86";
        String os = "Linux";
        String vmm = "Xen";
        double time_zone = 10.0;
        double cost = 3.0;
        double costPerMem = 0.05;
        double costPerStorage = 0.001;
        double costPerBw = 0.0;

        LinkedList<Storage> storageList = new LinkedList<>();

        DatacenterCharacteristics characteristics =
                new DatacenterCharacteristics(
                        arch,
                        os,
                        vmm,
                        hostList,
                        time_zone,
                        cost,
                        costPerMem,
                        costPerStorage,
                        costPerBw
                );

        Datacenter datacenter = null;

        try {
            datacenter = new Datacenter(
                    name,
                    characteristics,
                    new VmAllocationPolicySimple(hostList),
                    storageList,
                    0
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return datacenter;
    }

    private static void printCloudletList(List<Cloudlet> list) {
        int size = list.size();
        Cloudlet cloudlet;

        String indent = "    ";

        Log.printLine(); 
        Log.printLine("========== OUTPUT =========="); 

        Log.printLine(
                "Cloudlet ID" + indent +
                "STATUS" + indent +
                "Start Time" + indent +
                "Finish Time"
        );

        for (Cloudlet value : list) {
            cloudlet = value;

            Log.print(indent + cloudlet.getCloudletId() + indent + indent);

           
            if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS) {
                Log.printLine( 
                        "SUCCESS" +
                        indent + indent +
                        cloudlet.getExecStartTime() +
                        indent + indent +
                        cloudlet.getFinishTime()
                );
            }
        }
    }
}
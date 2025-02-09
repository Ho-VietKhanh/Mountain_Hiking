package Model;

public class MountainDetails {
    private String mountainCode;
    private String mountainName;
    private String province;
    private int numberOfParticipants;
    private double totalOfCost;


    public MountainDetails(String mountainCode, String mountainName, String province) {
        this.mountainCode = mountainCode;
        this.mountainName = mountainName;
        this.province = province;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public String getMountainName() {
        return mountainName;
    }

    public void setMountainName(String mountainName) {
        this.mountainName = mountainName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public double getTotalOfCost() {
        return totalOfCost;
    }

    public void setTotalOfCost(double totalOfCost) {
        this.totalOfCost = totalOfCost;
    }

    public String toStringMountainInfo() {
        return String.format("%-23s %-23s %-23s", mountainCode, mountainName, province);
    }

    public String toStringStatistics(){
        return String.format("%-23s %-25s %-23s", mountainName, numberOfParticipants, totalOfCost);
    }
}

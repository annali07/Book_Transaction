package interface_adapter.calculate_revenue;

public class RevenueState {
    private String startDate;
    private String endDate;

    public RevenueState(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RevenueState() {
        this.startDate = "";
        this.endDate = "";
    }

    public String getStartDateString() {
        return startDate;
    }

    public String getEndDateString() {
        return endDate;
    }

    public void setStartDateString(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDateString(String endDate) {
        this.endDate = endDate;
    }

}

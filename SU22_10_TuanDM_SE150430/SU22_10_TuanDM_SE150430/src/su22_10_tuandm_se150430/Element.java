package su22_10_tuandm_se150430;

import java.util.ArrayList;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Element {

    private int ID; // thuộc tính ID
    private String TaskTypeID; // thuộc tính TaskTypeID
    private String content; // thuộc tính content
    private String date; // thuộc tính date
    private double planFrom; // thuộc tính from
    private double planTo; // thuộc tính to
    private String takeJob; // thuộc tính takejob
    private String Tester; // thuộc tính Tester

    /**
     * Tạo mới task
     */
    public Element() {
    }
// tạo task mới

    public Element(int ID, String TaskTypeID, String content, String date, double planFrom, double planTo, String takeJob, String Tester) {
        this.ID = ID;
        this.TaskTypeID = TaskTypeID;
        this.content = content;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.takeJob = takeJob;
        this.Tester = Tester;
    }

    
    //------------------begin getter and setter----------------------
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(String TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getTakeJob() {
        return takeJob;
    }

    public void setTakeJob(String takeJob) {
        this.takeJob = takeJob;
    }

    public String getTester() {
        return Tester;
    }

    public void setTester(String Tester) {
        this.Tester = Tester;
    }
    
//-----------------------end getter and setter--------------------
    @Override
    public String toString() {
        double time = planTo - planFrom;
        String planTime = String.format("%.1f", time);
        String result = String.format("%-7d%-20s%-12s%-15s%-7s%-15s%-15s", ID, content, TaskTypeID, date, planTime, takeJob, Tester);
        return result;
    }
}

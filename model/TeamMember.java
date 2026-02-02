package model;

import java.util.ArrayList;

public class TeamMember extends GenericUser {
    ArrayList<Bug> assignedBugs;
    public TeamMember(String username, String email, String password) {
        super(username, email, password);
        this.assignedBugs = new ArrayList<>();
    }
    public ArrayList<Bug> getAssignedBugs() {
        return assignedBugs;
    }
    public void setAssignedBugs(ArrayList<Bug> assignedBugs) {
        this.assignedBugs = assignedBugs;
    }
}

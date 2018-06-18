import java.util.ArrayList;

public class StaffCollection
{
	ArrayList<Staff> staffs;

	public StaffCollection() {
		staffs = new ArrayList<Staff>();
	}

	public void addStaff(Staff staff) {
		staffs.add(staff);
	}

	public void removeStaff(Staff staff) {
		staffs.remove(staff);
	}

	public ArrayList<Staff> getAllStaff() {
		return(staffs);
	}

	public Staff getStaffByIndex(int n) {
		return(staffs.get(n));
	}

	public int getStaffCount() {
		return(staffs.size());
	}
}

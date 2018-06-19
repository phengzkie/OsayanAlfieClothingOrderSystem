import java.util.ArrayList;

public class StaffCollection
{
	ArrayList<Staff> staff;

	public StaffCollection() {
		staff = new ArrayList<Staff>();
	}

	public void addStaff(Staff s) {
		staff.add(s);
	}

	public void removeStaff(Staff s) {
		staff.remove(s);
	}

	public ArrayList<Staff> getAllStaff() {
		return(staff);
	}

	public Staff getStaffByIndex(int n) {
		return(staff.get(n));
	}

	public int getStaffCount() {
		return(staff.size());
	}
}

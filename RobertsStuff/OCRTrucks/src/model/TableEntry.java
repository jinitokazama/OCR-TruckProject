package model;

public class TableEntry {
	/*
	 * 
	 * Each table entry has an id and a 
	 * flag to see if has been checked or not
	 * 
	 * 
	 */
	
	private String id = null;
	private boolean checked = false;

	/*
	 * For setting an entry that hasn't been checked
	 */
	public TableEntry(String id) {
		setId(id);
	}
	/*
	 * For setting both the id and check flag
	 */
	public TableEntry(String id, boolean checked) {
		setId(id);
		setChecked(checked);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}

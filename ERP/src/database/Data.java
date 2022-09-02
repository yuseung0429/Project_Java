package database;

public abstract class Data {
	abstract boolean save();
	boolean dirty = false;
}

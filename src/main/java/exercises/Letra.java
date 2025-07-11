package exercises;

@SuppressWarnings("hiding")
public class Letra <String>{
	private String data;
	private int count;
	private Letra<String> next;
	
	public Letra() {
		this.data = null;
		this.count = 0;
		this.next = null;
	}
	public Letra(String data) {
		this.data = data;
		this.count = 1;
		this.next = null;
	}
	public Letra(String data, int i,Letra<String> next) {
		this.data = data;
		this.count = i;
		this.next=next;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Letra<String> getNext() {
		return next;
	}
	public void setNext(Letra<String> next) {
		this.next = next;
	}
}


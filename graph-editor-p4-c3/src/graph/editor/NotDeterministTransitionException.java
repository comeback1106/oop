package graph.editor;

public class NotDeterministTransitionException extends Exception {
	private static final long serialVersionUID = 1L;

	private Edge e1, e2;

	public NotDeterministTransitionException(Edge e1, Edge e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	public String getMessage() {
		return "Duplicated transition " + e1 + ", " + e2;
	}
}

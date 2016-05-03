package graph.editor;

public class NotDeterministInitialStateException extends Exception {
	private static final long serialVersionUID = 1L;

	private Vertex v1, v2;

	public NotDeterministInitialStateException(Vertex v1, Vertex v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public String getMessage() {
		return "Two initial states " + v1 + " and " + v2;
	}
}

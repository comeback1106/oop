package graph.editor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class DeterministicAutomaton {

	private Vertex initialVertex = null;

	private final Map<Vertex, Map<String, Edge>> Edges;

	public DeterministicAutomaton(List<Edge> edges2) throws NotDeterministInitialStateException,
			UnknownInitialStateException, NotDeterministInitialStateException {
		this.Edges = new HashMap<Vertex, Map<String, Edge>>();
		for (Edge e : edges2) {
			addVertex(e.source);
			addVertex(e.target());

			Map<String, Edge> map = this.Edges.get(e.source());
			if (map.containsKey(e.getLabel())) {
				throw new NotDeterministInitialStateException(e.source, map.get(e.getLabel()).source);
			} else {
				map.put(e.getLabel(), e);
			}
		}
		if (initialVertex == null) {
			throw new UnknownInitialStateException();
		}
	}

	protected final void addVertex(Vertex s) throws NotDeterministInitialStateException {
		if (!Edges.containsKey(s)) {
			Edges.put(s, new HashMap<String, Edge>());
			if (s.initial()) {
				if (initialVertex == null) {
					initialVertex = s;
				} else {
					throw new NotDeterministInitialStateException(s, initialVertex);
				}
			}
		}
	}

	public Vertex initialVertex() {
		return initialVertex;
	}

	public Edge Edge(Vertex s, String label) {
		if (!Edges.containsKey(s)) {
			throw new NoSuchElementException();
		}
		return Edges.get(s).get(label);
	}

	public boolean recognize(String... word) {
		return recognize(Arrays.asList(word).iterator());
	}

	public boolean recognize(Iterator<String> word) {
		Vertex s = initialVertex;
		while (word.hasNext()) {
			Edge t = Edge(s, word.next());
			if (t == null) {
				return false;
			} else {
				s = changeCurrentVertex(t);
			}
		}
		return s.terminal();
	}

	protected Vertex changeCurrentVertex(Edge t) {
		return t.target();
	}
}
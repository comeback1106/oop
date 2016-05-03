package graph.editor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;

public class Vertex {
	RectangularShape shape;

	String label;
	boolean initial=false, terminal=false;

	Vertex(RectangularShape rs, String label) {
		this.shape = rs;
		this.label = label;
	}
	
	public boolean initial() {
		return initial;
	}
	
	public void setInitial(boolean initial){
		this.initial = initial;
	}

	public boolean terminal() {
		return terminal;
	}
	
	public void setTerminal(boolean terminal){
		this.terminal = terminal;
	}

	public RectangularShape getShape() {
		return shape;
	}

	public void setShape(RectangularShape shape) {
		this.shape = shape;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean contains(int x, int y) {
		return shape.contains(x, y);
	}

	void draw(Graphics2D g2) {
		g2.fill(shape);
		g2.setColor(Color.WHITE);
		g2.drawString(label, (int) shape.getCenterX()-5,(int) shape.getCenterY()-5);
	}
}

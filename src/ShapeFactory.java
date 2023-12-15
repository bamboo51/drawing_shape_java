// ShapeFactory.java

/*
	パターン Factory　を利用する．
	Factory は新しいオブジェクトを生成追加する処理を標準化したものである．
	メインクラスの中で図形の種類分けを具体的に描くことを避け、
	Factory クラス（ここではShapeFactory ）を使って、
	その中で図形の種類分けによる図形オブジェクト生成を記述している．
	それによって、図形の種類が増えた場合にも対応しやすくなる． 
 */

public class ShapeFactory {
	private Shape sh;
	
	// state の値に従って、クラスを作り分ける. 
	public Shape createShape(int state, int x, int y) {
		if ( state == Shape.CIRCLE) {
			sh = new Circle(x, y);
		} else if(state == Shape.RECTANGLE) {
			sh = new Rectangle(x, y);
		} else {
			sh = new Line(x, y);
		}
		return sh;
	}
}

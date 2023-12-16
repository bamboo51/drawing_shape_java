// Sample4.java
// 簡単なお絵描きツール　ボタン版 
/*
 * フレームの上にボタンを配置し、そのボタンをマウスでクリックすると、
 * ボタンの画像の図形を描画する。
 * パターン Factoryを利用し Sample3を修正する。
 * 図形追加のために、ShapeFactory クラスを導入する。
*/

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class App extends JFrame implements ActionListener {
	/* 
	 JFrame （ウィンドウ）を使い, その上に描画用のパネル, ボタン, ツールバー
	　を配置する。
	　ボタンを押すとその図形がパネル上に描画される。
	*/
	private SamplePanel sp;
	private JButton bt[] = new JButton[6];
	private JToolBar tl;
	private Icon ic;
//	private Shape sh;
	private int state; // 描画図形種類を表す
	private JToolBar ts;

	// create save button
	Icon saveIcon = new ImageIcon("../icon/Save.gif");
	JButton saveButton = new JButton(saveIcon);

	public static void main(String[] args) {
		 App sm = new  App();
	}
	
	public App() {
		/*
		 コンストラクタではフレーム（ウィンドウ）の設定, 
		 ボタンとパネルの配置を行う。
		 */
		super("Drawing Shape"); 		// タイトルを表示
		sp = new SamplePanel();
		tl = new JToolBar();
		ts = new JToolBar();
		saveButton.addActionListener(this);
		
		for(int i=0; i<bt.length; i++) {
			ic = new ImageIcon("../icon/"+Shape.name[i] + ".gif");
			bt[i] = new JButton(ic);
			bt[i].setToolTipText(Shape.name[i]);
			bt[i].addActionListener(this);
			tl.add(bt[i]);
			/*
			  各図形のボタンに画像を貼り付け、アクションリスナー（マウス動作のチェック）を追加．
			そして、ツールバーに各ボタンを追加
			*/
		}
		ts.add(saveButton);
		
		add(tl, BorderLayout.NORTH); 	// ツールバー（ボタン群）を上部に配置
		add(sp, BorderLayout.CENTER);	// パネルを中央に配置
		add(saveButton, BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);	// ウィンドウを閉じたら終了
		setSize(600, 600);
		setVisible(true);				// 表示開始
	}
	
	/*
	 * マウスボタンが押された時の動作を規定するメソッド 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton tmp = (JButton) e.getSource();
		
		if (tmp == bt[0]) {
			state = Shape.CIRCLE;
		} else if (tmp == bt[1]) {
			state = Shape.RECTANGLE;
		} else if (tmp == bt[2]){
			state = Shape.LINE;
		} else if (tmp == bt[3]){
			state = Shape.TRIANGLE;
		} else if (tmp == bt[4]){
			state = Shape.STAR;
		} else if (tmp == bt[5]){
			state = Shape.HEXAGON;
		} else if (tmp == saveButton){
			saveDrawing();
		}

		/*
		 * ボタンによって、CIRCLE か RECTANGLE か LINE を指定する．
		 */
	}

	public void saveDrawing() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".png")) {
                filePath += ".png"; // Ensure the file has a .png extension
            }
            saveAsPNG(filePath, sp.getShapeList());
        }
    }

    public void saveAsPNG(String filePath, List<Shape> shapelist) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Draw shapes from the shapelist
        for (Shape sh : shapelist) {
            sh.draw(g2d);
        }

        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public class SamplePanel extends JPanel{
		private ArrayList<Shape> shapelist = new ArrayList<Shape>();
		// 描画する図形はリスト shapelist で管理する。
		// Shape 型のリストとすれば、そのサブクラスも利用できる。
		
		public SamplePanel() {
			addMouseListener( new SampleMouseListener() );
			/*
			 マウスの動作のチェック
			 下で定義される SampleMouseListener を採用する．
			 */
		}
		/*
		 描画用のメソッド paint
		 何らかのイベントが発生するごとに描画し直される．
		 */
		public void paint(Graphics g) {
			super.paint(g);
			Iterator<Shape>  it = shapelist.iterator();
			while( it.hasNext() ) {
				Shape sh = it.next();
				sh.draw(g);
			}
			/*
			 Iterator< >  は繰り返し処理用のリスト
			 この場合、追加された図形から順番に描画される．
			 */
		}
	
		public class SampleMouseListener extends MouseAdapter{
			/*
			 マウスの動作を追跡して、何か起こったら該当する動作に対応する処理を
			記述しておく。
			この場合は、マウスボタンが押された場合( mousePressed ）の処理を規定している．
			 */
			public void mousePressed(MouseEvent e) {
				/*
				 マウスボタンが押されたとき、ボタンによって図形の種類が選択され、
				 それぞれに該当する図形のオブジェクトを生成し、shapelistに追加する．
				 追加後、再描画（repaint ）する．
				 */

				/* 
				ここで、パターン Factory　を利用する．
				Factory は新しいオブジェクトを生成追加する処理を標準化したものである．
				メインクラスの中で図形の種類分けを具体的に描くことを避け、
				Factory クラス（ここではShapeFactory ）を使って、
				その中で図形の種類分けによる図形オブジェクト生成を記述している．
				それによって、図形の種類が増えた場合にも対応しやすくなる． 
				*/
				
				ShapeFactory sf = new ShapeFactory();
				Shape sh = sf.createShape(state, e.getX(), e.getY());
				shapelist.add(sh);
				repaint();
			}
		}

		public ArrayList<Shape> getShapeList(){
			return shapelist;
		}
	}
}

package ch10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice10_open extends JFrame {
	//배열의 인덱스 값을 설정할때 사용할 변수
	int imgNumber =0;
	//배열을 사용해 이미지요소를 제어할 이미지아이콘 배열 
	ImageIcon[] arrayImgcon = new ImageIcon[4];
	//화면에 보여줄 이미지레이블 참조변수
	JLabel imgLabel;
	//이미지를 바꿀때 사용할 이미지 버튼 생성
	ImageIcon imgRight = new ImageIcon("images/right.png");
	ImageIcon imgLeft = new ImageIcon("images/left.png");
	JButton btnRight = new JButton(imgRight);
	JButton btnLeft = new JButton(imgLeft);
	
	practice10_open() {
		setTitle("오픈 챌린지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		for (int i = 0; i < 4; i++) {
			//이미지 파일의 주소 입력
			String imgfile = "images/image"+i+".jpg";
			//이미지아이콘 배열에 값을 넣어줌
			arrayImgcon[i] = new ImageIcon(imgfile);
		}//end for
		//이미지 아이콘들을 생성해줬으므로 해당 이미지를 레이블에 등록
		imgLabel = new JLabel(arrayImgcon[imgNumber]);
		
		//이미지레이블을 가운데 붙여줌
		con.add(imgLabel, BorderLayout.CENTER);
		//이미지를 바꿔줄 패널을 남쪽에 등록
		con.add(new movePanel(),BorderLayout.SOUTH);

		setSize(300,400);
		setVisible(true);
	}

	class movePanel extends JPanel{
		movePanel(){
			setBackground(Color.GRAY);
			//버튼을 눌렀을때 이미지를 바꿔줄 마우스 이벤트 등록
			btnRight.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					imgNumber++;
					//이미지 넘버값이 이미지배열의 크기 보다 크면 에러가 발생하므로 
					if(imgNumber>=arrayImgcon.length) {
						//이미지 넘버값에 이미지배열의 크기만큼 빼줘서 처리
						imgNumber = imgNumber-arrayImgcon.length;
					}
					//이미지레이블에 다시 이미지등록
					imgLabel.setIcon(arrayImgcon[imgNumber]);
				}
			});
			
			//버튼을 눌렀을때 이미지를 바꿔줄 마우스 이벤트 등록
			btnLeft.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					imgNumber--;
					//이미지 넘버값이  음수면 에러 발생
					if(imgNumber<0) {
						//음수값이 나왔다는 말은 첫번째요소 앞의 것이므로 배열 마지막요소의 값을 주면됨 
						imgNumber = arrayImgcon.length -1;
					}
					//이미지레이블에 다시 이미지등록
					imgLabel.setIcon(arrayImgcon[imgNumber]);
				}
			});
			//이미지를 바꿔줄 버튼 추가
			add(btnLeft);
			add(btnRight);
			
		}
	}
public static void main(String[] args) {
	new practice10_open();
}
}

package JavaSwingLecture;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice10_03 extends JFrame {
	practice10_03() {
		setTitle("라디오버튼 문제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		//라디오 버튼을 묶어줄 buttongroup생성
		ButtonGroup group = new ButtonGroup();
		//라디오버튼으로 클릭하면 배경색을 빨간색으로 바꿔줄 버튼 생성
		JRadioButton radio_red = new JRadioButton("Red");
		//라디오버튼에 익명클래스로 아이템리스너를 슈퍼클래스로하는 이벤트 리스너등록
		radio_red.addItemListener(new ItemListener() {
			//아이템상태가 바꼈을 때 동작할 메서드 오버라이딩
			@Override
			public void itemStateChanged(ItemEvent e) {
				//현재 아이템이벤트의 상태를 반환하는 메서드로 아이템이 선택됬을때 수행
				if(e.getStateChange()==ItemEvent.SELECTED) {
					//컨테이너 참조변수를 사용 배경색을 바꿔줌
					con.setBackground(Color.RED);
				}
			}
		});
		
		//위 red버튼과 마찬가지로 동일하게 등록
		JRadioButton radio_blue = new JRadioButton("Blue");
		radio_blue.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					con.setBackground(Color.BLUE);
				}
			}
		});
		//만들어준 radio버튼들을 하나만 선택되게 묶어준 group에 추가시켜줌
		group.add(radio_red);
		group.add(radio_blue);
		//컨테이너에 버튼 부착
		con.add(radio_red);
		con.add(radio_blue);

		setSize(400,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new practice10_03();
	}
}

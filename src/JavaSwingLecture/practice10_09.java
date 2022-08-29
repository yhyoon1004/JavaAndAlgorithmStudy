package JavaSwingLecture;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.*;


public class practice10_09 extends JFrame{
	//화면에 표기할 컴포넌트 요소 정의
	JLabel labelEng = new JLabel("영어");
	JLabel labelkor = new JLabel("한글");
	JLabel labelcount = new JLabel();
	//10열의 텍스트필드 생성
	JTextField textEng = new JTextField(10);
	JTextField textKor = new JTextField(10);
	//동작을 수행할 버튼 생성
	JButton btnSave = new JButton("저장");
	JButton btnFind = new JButton("찾기");
	//10행10열의 텍스트에어리어 생성
	JTextArea textArea = new JTextArea(10,15);
	//해쉬맵을 이용해 키값 쌍을 영어-한글로 매칭해서 단어를 저장
	HashMap<String,String> hashmapWord = new HashMap<>();
	
	//단어수를 저장할 int형 변수
	int countWord =0;

	practice10_09(){
		setTitle("영한 단어장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		//저장 버튼을 눌렀을 때 동작설정
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//영어랑, 한글 값이 있으면 실행
				if(textEng.getText()!=""||textKor.getText()!="") {
					//해당하는 영단어 값이 있으면 변경 수행
					if(hashmapWord.get(textEng.getText())!=null) {
						//해쉬맵에 값을 넣어 변경해줌
						hashmapWord.put(textEng.getText(), textKor.getText());
						//textArea에 값 변경을 표시
						textArea.append("변경 ("+textEng.getText()+", ("+textKor.getText()+")\n");
					}
					else {
						hashmapWord.put(textEng.getText(), textKor.getText());
						//textArea에 값 삽입을 표시
						textArea.append("삽입 ("+textEng.getText()+", ("+textKor.getText()+")\n");
						//값이 삽입되었으므로 count추가
						countWord++;
					}
				}
				//단어 개수를 설정
				labelcount.setText(Integer.toString(countWord));
			}
		});//save버튼 끝
		
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//해당 영단어를 키값으로 하는 hashword의 value값이 있을 경우 수행
				if(hashmapWord.get(textEng.getText())!=null) {
					//한글 텍스트필드의 텍스트값을 영어택스트의 값에 해당하는 value값으로 넣어줌
					textKor.setText(hashmapWord.get(textEng.getText()));
				}
			}
		});
		
		//설정한 컴포넌트를 컨테이너에 부착
		con.add(labelEng);
		con.add(textEng);
		con.add(labelkor);
		con.add(textKor);
		con.add(btnSave);
		con.add(btnFind);
		con.add(labelcount);
		con.add(textArea);
		
		setSize(320,250);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new practice10_09();
	}

}

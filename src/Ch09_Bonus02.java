import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ch09_Bonus02 extends JFrame {
	//수식과 결과를 표기할 레이블
	JLabel label01 = new JLabel("수식");
	JLabel label02 = new JLabel("결과");
	//입력결과를 표기할 10자의 텍스트필드 요소 생성
	JTextField Text_function = new JTextField(10);
	JTextField Text_result = new JTextField(10);

	//키패드역할을 할 버튼배열 생성
	JButton[] btn_number = new JButton[10];
	//기타 초기화, 계산, 연산을 할 버튼들 생성
	JButton btn_ce = new JButton("CE");
	JButton btn_calc = new JButton("계산");
	JButton btn_sum = new JButton("+");
	JButton btn_minus = new JButton("-");
	JButton btn_mul = new JButton("x");
	JButton btn_div = new JButton("/");

	Ch09_Bonus02() {
		super("간단한 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		//JFrame은 기본이 borderLayout이므로 별도로 배치관리자 설정은 안함
		//결과를 표시할 Bar패널을 북쪽에 배치
		con.add(new Bar(), BorderLayout.NORTH);
		//키패드역할을 할 Keypad패널을 가운데 배치
		con.add(new Keypad(),BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
	}
	
	//결과를 표시할 Bar패널
	class Bar extends JPanel {
		
		Bar() {
			//패널 배경색을 입힘
			setBackground(Color.lightGray);
			//레이블과 텍스트 필드 요소를 패널에 추가
			add(label01);
			add(Text_function);
			add(label02);
			add(Text_result);
		}
	}

	//키패드역할을 할 Keypad패널
	class Keypad extends JPanel {
		Keypad() {
			//맨 아래 행 버튼 요소에 배경색을 입힘
			btn_sum.setBackground(Color.orange);
			btn_minus.setBackground(Color.orange);
			btn_mul.setBackground(Color.orange);
			btn_div.setBackground(Color.orange);
			
			//해당 패널에 gridLayout으로 4행 4열 수직·수평여백 각각10픽셀의 배치관리자 설정
			setLayout(new GridLayout(4,4,10,10));
			
			//[숫자버튼] for문을 이용하여 숫자버튼을 생성, 이벤트등록, keypad패널에 부착
			for (int i = 0; i < btn_number.length; i++) {
				//이벤트리스너 등록할 때 익명클래스에 지역변수를 사용할 수 없음으로 반복문 변수값을 따로저장 
				int btn_numValues = i;
				//버튼 배열 참조변수에 버튼를 초기화
				btn_number[i]= new JButton(Integer.toString(i));
				//버튼에 마우스리스너를 등록해 버튼을 클릭할 때 해당 값을 텍스트 필드에 넣어줌
				//전부 구현할 필요가 없으므로 어뎁터클래스로 익명클래스 작성
				btn_number[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//기존 텍스트값에 위에서 초기화해준 버튼의 텍스트값(btn_numValues)를 더해서 초기화해줌
						String editedtext = Text_function.getText()+btn_numValues;
						//텍스트 필드에 초기화해준 값을 넣어줌
						Text_function.setText(editedtext);
					}
				});
				//버튼을 패널에 등록
				add(btn_number[i]);
			}
			
			//[CE]버튼
			btn_ce.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					Text_function.setText("");
				}
			});
			add(btn_ce);
			
			//[계산버튼]
			btn_calc.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					//수식 텍스필드의 값을 받아와 String으로 초기화
					String funcText = Text_function.getText();
					//반복문에서 숫자값을 받아 처리할 변수
					String temp="";
					//입력한수식의 피연산자 2개 생성
					String value01 = "";
					String value02 = "";
					//연산부호를 저장하는 변수
					char calculation = ' ';
					//처리한 결과값을 담아둘 변수
					int result=0;
					//반복문을 이용하여 수식문자열값을 피연산자와 연산자로 나눔
					for(int i = 0; i<funcText.length();i++) {
						//i번째 문자열의 문자가 연산자이면 해당 값을 연산자 변수 calculation에 저장하고
						//전에 저장해 놓았던 temp값을 피연산자값value01에 저장, 
						//temp에 있는 값을 지워주고 continue로 다음 반복수행
						switch(funcText.charAt(i)) {
						case '+': calculation = '+';value01=temp;temp="";continue;
						case '-': calculation = '-';value01=temp;temp="";continue;
						case 'x': calculation = 'x';value01=temp;temp="";continue;
						case '/': calculation = '/';value01=temp;temp="";continue;
						}
						//해당 문자열의 문자값이 연산자가 아니면 숫자값을 temp에 저장
						temp+=funcText.charAt(i);
						//마지막 반복일 경우, 남아있는 temp값을 피연산자값 value02에 저장
						if(i==funcText.length()-1) {
							value02 = temp;
							}
					}//반복문 종료
					//저장받은 calculation값에 해당하는 연산을 처리하여 result에 저장
					switch(calculation) {
					case '+': calculation = '+';result = Integer.parseInt(value01)+Integer.parseInt(value02);break;
					case '-': calculation = '-';result = Integer.parseInt(value01)-Integer.parseInt(value02);break;
					case 'x': calculation = 'x';result = Integer.parseInt(value01)*Integer.parseInt(value02);break;
					case '/': calculation = '/';result = Integer.parseInt(value01)/Integer.parseInt(value02);break;
					}
					//저장한 int값을 문자열과 더해 결과텍스트필드 값에 넣어줌
					Text_result.setText(""+result);
				}
			});
			add(btn_calc);
			////////////////////////////////아래 버튼 등록하는 코드는  위의 버튼을 등록하는 과정과 동일
			btn_sum.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					String editedText = Text_function.getText()+"+";
					Text_function.setText(editedText);
				}
			});
			add(btn_sum);
			
			btn_minus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					String editedText = Text_function.getText()+"-";
					Text_function.setText(editedText);
				}
			});
			add(btn_minus);
			
			btn_mul.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					String editedText = Text_function.getText()+"x";
					Text_function.setText(editedText);
				}
			});
			add(btn_mul);
			
			btn_div.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					String editedText = Text_function.getText()+"/";
					Text_function.setText(editedText);
				}
			});
			add(btn_div);
		}
	}



	public static void main(String[] args) {
		new Ch09_Bonus02();
	}
}

/*
 * ComCmd.java
 *
 * Created on __DATE__, __TIME__
 */

package mypage;

import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import mypage.accessApiPro;
import mypage.userMes;
import mypage.FriendMes;

/**
 *
 * @author  __USER__
 */
public class ComCmd extends javax.swing.JFrame {

	private accessApiPro accessApi = new accessApiPro();
	private FriendMes friendMes = new FriendMes();
	private userMes user;
	private String uId;
	private String accessToken = "";
	private boolean ifReply = true;
	private Timer timer;

	/** Creates new form ComCmd */
	public ComCmd() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		getCodeBtn = new javax.swing.JButton();
		codeText = new javax.swing.JTextField();
		codeEnterBtn = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		userMesText = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		friendMesList = new javax.swing.JList();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		commentText = new javax.swing.JTextArea();
		jLabel3 = new javax.swing.JLabel();
		friendChoT = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		consoleText = new javax.swing.JTextArea();
		comEnterBtn = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		stopReplyBtn = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		helpBtn = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u5fae\u535a\u81ea\u52a8\u8bc4\u8bba\u673a1.0");
		setBackground(new java.awt.Color(153, 255, 255));
		setBounds(new java.awt.Rectangle(200, 200, 0, 0));
		setForeground(new java.awt.Color(204, 255, 255));
		setResizable(false);

		getCodeBtn.setFont(new java.awt.Font("宋体", 0, 12));
		getCodeBtn.setText("\u70b9\u51fb\u8fdb\u884c\u6388\u6743");
		getCodeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				getCodeBtnAction(evt);
			}
		});

		codeText.setFont(new java.awt.Font("宋体", 0, 12));

		codeEnterBtn.setFont(new java.awt.Font("宋体", 0, 12));
		codeEnterBtn.setText("\u786e\u5b9a");
		codeEnterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				getTokenAction(evt);
			}
		});
		codeEnterBtn
				.addAncestorListener(new javax.swing.event.AncestorListener() {
					public void ancestorMoved(
							javax.swing.event.AncestorEvent evt) {
						codeEnterBtnAncestorMoved(evt);
					}

					public void ancestorAdded(
							javax.swing.event.AncestorEvent evt) {
					}

					public void ancestorRemoved(
							javax.swing.event.AncestorEvent evt) {
					}
				});

		jLabel1.setFont(new java.awt.Font("宋体", 0, 12));
		jLabel1.setForeground(new java.awt.Color(0, 153, 153));
		jLabel1.setText("\u8f93\u5165\u6388\u6743Code\uff1a");

		userMesText.setBackground(new java.awt.Color(237, 237, 238));
		userMesText.setColumns(20);
		userMesText.setEditable(false);
		userMesText.setFont(new java.awt.Font("宋体", 0, 13));
		userMesText.setRows(5);
		userMesText.setText("\u57fa\u672c\u4fe1\u606f\uff1a\n");
		jScrollPane1.setViewportView(userMesText);

		friendMesList.setBackground(new java.awt.Color(238, 237, 237));
		friendMesList.setFont(new java.awt.Font("宋体", 0, 12));
		friendMesList.setModel(new javax.swing.AbstractListModel() {
			String[] strings = {""};

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		friendMesList.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				friendMesListMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(friendMesList);

		jLabel2.setFont(new java.awt.Font("宋体", 0, 12));
		jLabel2.setText("\u8bc4\u8bba\u5185\u5bb9\uff1a");

		commentText.setColumns(20);
		commentText.setFont(new java.awt.Font("宋体", 0, 13));
		commentText.setRows(5);
		jScrollPane3.setViewportView(commentText);

		jLabel3.setFont(new java.awt.Font("宋体", 0, 12));
		jLabel3.setText("\u5df2\u9009\u597d\u53cb\uff1a");

		friendChoT.setEditable(false);
		friendChoT.setFont(new java.awt.Font("宋体", 0, 12));

		jLabel4.setFont(new java.awt.Font("宋体", 0, 12));
		jLabel4.setText("\u597d\u53cb\u5217\u8868\uff1a");

		jLabel5.setFont(new java.awt.Font("新宋体", 0, 12));
		jLabel5.setText("\u63a7\u5236\u53f0\u4fe1\u606f\uff1a");

		consoleText.setBackground(new java.awt.Color(238, 237, 237));
		consoleText.setColumns(20);
		consoleText.setEditable(false);
		consoleText.setFont(new java.awt.Font("宋体", 0, 13));
		consoleText.setRows(5);
		jScrollPane4.setViewportView(consoleText);

		comEnterBtn.setFont(new java.awt.Font("宋体", 0, 12));
		comEnterBtn.setText("\u5f00\u59cb\u8bc4\u8bba");
		comEnterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				comEnterBtnMouseClicked(evt);
			}
		});

		jLabel6.setText("http://home.ustc.edu.cn/~sa512001");

		jLabel7.setFont(new java.awt.Font("宋体", 0, 12));
		jLabel7.setText("\u57fa\u672c\u4fe1\u606f\uff1a");

		stopReplyBtn.setFont(new java.awt.Font("宋体", 0, 12));
		stopReplyBtn.setText("\u505c\u6b62\u8bc4\u8bba");
		stopReplyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				stopReplyBtnMouseClicked(evt);
			}
		});

		helpBtn.setText("\u4f7f\u7528\u65b9\u6cd5\u3001\u7b80\u4ecb");
		helpBtn.setFont(new java.awt.Font("宋体", 0, 12));
		helpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				helpBtnMouseClicked(evt);
			}
		});
		jMenuBar1.add(helpBtn);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						100,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addContainerGap()
																								.addComponent(
																										jScrollPane2,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										152,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addContainerGap()
																								.addComponent(
																										jScrollPane1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jLabel6))
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.LEADING,
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGap(30,
																																		30,
																																		30)
																																.addComponent(
																																		jLabel5))
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGap(31,
																																		31,
																																		31)
																																.addGroup(
																																		layout.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING)
																																				.addComponent(
																																						jLabel2,
																																						javax.swing.GroupLayout.PREFERRED_SIZE,
																																						86,
																																						javax.swing.GroupLayout.PREFERRED_SIZE)
																																				.addComponent(
																																						jLabel3))))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																												.addComponent(
																														jScrollPane3,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														234,
																														Short.MAX_VALUE)
																												.addComponent(
																														comEnterBtn,
																														javax.swing.GroupLayout.Alignment.LEADING,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														234,
																														Short.MAX_VALUE)
																												.addComponent(
																														jScrollPane4,
																														javax.swing.GroupLayout.Alignment.LEADING,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														234,
																														Short.MAX_VALUE)
																												.addComponent(
																														friendChoT,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														234,
																														Short.MAX_VALUE)
																												.addComponent(
																														stopReplyBtn,
																														javax.swing.GroupLayout.Alignment.LEADING,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														234,
																														Short.MAX_VALUE)))))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		97,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(38, 38,
																		38)
																.addComponent(
																		codeText,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		292,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		codeEnterBtn,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		86,
																		Short.MAX_VALUE))
												.addComponent(
														getCodeBtn,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														520, Short.MAX_VALUE)
												.addComponent(jLabel7))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(getCodeBtn)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														codeText,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1)
												.addComponent(codeEnterBtn))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7)
												.addComponent(jLabel2))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(jScrollPane1)
												.addComponent(
														jScrollPane3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														86,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(
																		jLabel4)
																.addComponent(
																		jLabel3))
												.addComponent(
														friendChoT,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(25, 25,
																		25)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel5)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jScrollPane4,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										171,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(6,
																										6,
																										6)
																								.addComponent(
																										comEnterBtn)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										stopReplyBtn)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jLabel6,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										20,
																										Short.MAX_VALUE))))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jScrollPane2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		268,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void helpBtnMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		String messageStr = "  简介：本软件为对授权用户的指定关注好友，进行自动微博回复，\n"
				+ "你只需选择需要自动回复的关注好友并运行软件，接下来你就可以做\n"
				+ "其他事情去了，本软件会替你回复指定用户所发布的所有新微博，只\n"
				+ "要指定回复的用户一发布新微博，我们就会对他进行回复！\n"
				+ "  使用方法：首先点击授权，授权本应用对你的微博进行操作，然后将\n"
				+ "弹出网页上的URl后的code=的内容复制进入输入code框中，点击授权\n"
				+ "即可。接下来应用会读取你的信息，并提供关注列表你只需选择好友，\n" + "后输入回复内容，点击开始评论即可。\n"
				+ "  制作者：雨天戴帽子，http://home.ustc.edu.cn/~sa512001\n"
				+ "  注：由于本应用为试用版，未经过新浪审核，所以每小时评论次\n" + "数有限制，且需要进行网页验证\n"
				+ "如若需要相关高级应用，可使用完整版！\n";
		Font font = new Font("宋体", Font.PLAIN, 14);
		UIManager.put("Label.font", font);
		UIManager.put("Button.font", font);
		JOptionPane.showMessageDialog(null, messageStr, "使用方法，简介",
				JOptionPane.NO_OPTION);
	}

	private void stopReplyBtnMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		timer.cancel();
		consoleText.append("评论结束\n");
	}

	private void comEnterBtnMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		String friendName = friendChoT.getText();
		String comment = commentText.getText();
		if (!friendName.equals("")) {
			timer = new Timer();
			consoleText.append("进入评论!\n");
			Task taskOne = new Task(friendName, this.accessToken, comment);
			timer.schedule(taskOne, 100, 1000);

		} else {
			consoleText.append("请选择好友!\n");
		}

	}

	private void friendMesListMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		String str = (String) friendMesList.getSelectedValue();
		friendChoT.setText(str);

	}

	private void codeEnterBtnAncestorMoved(javax.swing.event.AncestorEvent evt) {
		// TODO add your handling code here:
	}

	private void getTokenAction(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		String code = codeText.getText();
		if (code.equals("")) {
			consoleText.setText("未输入Code！\n");
			return;
		}
		String str[] = accessApi.myGetToken(code);
		this.accessToken = str[0];
		uId = str[1];
		jLabel1.setVisible(false);
		codeText.setVisible(false);
		codeEnterBtn.setVisible(false);
		user = new userMes(this.accessToken, uId);
		userMesText.append("昵称：" + user.getuName() + "\n" + "关注数："
				+ user.getFriendNum() + "\n" + "粉丝数：" + user.getFllowedNum());
		consoleText.append("好友列表加载中...\n");
		List<User> users = null;
		users = friendMes.getFriendList(this.accessToken, uId);
		String[] item = null;
		DefaultListModel listModel = new DefaultListModel();
		for (User u : users) {
			System.out.println(u.getName());
			listModel.addElement(u.getName());

			//			listModel.addElement(u);  ////////////////////////////////////////////测试直接加U会有什么后果！！！！
		}
		friendMesList.setModel(listModel);
		friendMesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		consoleText.append("好友列表加载完毕\n");
	}

	private void getCodeBtnAction(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		this.codeText.setVisible(true);
		this.codeEnterBtn.setVisible(true);
		this.jLabel1.setVisible(true);
		try {
			accessApi.getCode();
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ComCmd().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton codeEnterBtn;
	private javax.swing.JTextField codeText;
	private javax.swing.JButton comEnterBtn;
	private javax.swing.JTextArea commentText;
	private javax.swing.JTextArea consoleText;
	private javax.swing.JTextField friendChoT;
	private javax.swing.JList friendMesList;
	private javax.swing.JButton getCodeBtn;
	private javax.swing.JMenu helpBtn;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JButton stopReplyBtn;
	private javax.swing.JTextArea userMesText;
	// End of variables declaration//GEN-END:variables

}

class Task extends TimerTask {
	private String preStatusId = "";
	private String statusId;
	private String friendName;
	private String accessToken;
	private String comment;
	private FriendMes friendMes = new FriendMes();

	public Task(String friendName, String accessToken, String comment) {
		this.friendName = friendName;
		this.comment = comment;
		this.accessToken = accessToken;
	}

	public void run() {
		statusId = friendMes.GetFriendStatusIds(accessToken, friendName);
		if (!preStatusId.equals(statusId)) {
			preStatusId = statusId;
			friendMes.giveReply(this.accessToken, statusId, comment);
		} else {
			System.out.println("微博一样··不重复评论···\n");
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

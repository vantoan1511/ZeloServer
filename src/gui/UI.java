package gui;

import java.io.IOException;
import main.ZeloServer;

public class UI extends javax.swing.JFrame {

    public UI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        server_version = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        server_status = new javax.swing.JLabel();
        start_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        log_section = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zelo Server");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Zelo_icon_64.png"))); // NOI18N
        jPanel1.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 104, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        title.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        title.setForeground(new java.awt.Color(0, 104, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        title.setText("SERVER SIDE");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        version.setText("version:");
        jPanel1.add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 750, -1, 20));

        server_version.setText("1.0");
        jPanel1.add(server_version, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 750, -1, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 104, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tình Trạng: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        server_status.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        server_status.setForeground(new java.awt.Color(255, 104, 0));
        server_status.setText("đã dừng");
        jPanel1.add(server_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        start_btn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        start_btn.setForeground(new java.awt.Color(0, 104, 255));
        start_btn.setText("Khởi động");
        start_btn.setToolTipText("Click để khởi động server");
        start_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        start_btn.setFocusPainted(false);
        start_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_btnActionPerformed(evt);
            }
        });
        jPanel1.add(start_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        log_section.setEditable(false);
        log_section.setColumns(20);
        log_section.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        log_section.setRows(5);
        jScrollPane1.setViewportView(log_section);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 500, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void start_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_btnActionPerformed

        try {
            server.startServer();
            if (server.isRunning) {
                server_status.setText(RUNNING);
                this.isRunning = true;
                start_btn.setEnabled(false);
            }
        } catch (IOException ex) {
            System.out.println("Lỗi không xác định!");
        }
    }//GEN-LAST:event_start_btnActionPerformed

    public static void main(String args[]) {
        
        WindowUI.setWindowsUI();

        UI ui = new UI();

        ui.setVisible(true);
        server = new ZeloServer(ui);

    }

    public void writeLog(String str) {
        log_section.append(str);
    }

    //
    public static final String RUNNING = "Đang chạy";
    public static final String STOPPED = "Đã dừng";
    public boolean isRunning = false;
    private static ZeloServer server;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea log_section;
    private javax.swing.JLabel server_status;
    private javax.swing.JLabel server_version;
    private javax.swing.JButton start_btn;
    private javax.swing.JLabel title;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}

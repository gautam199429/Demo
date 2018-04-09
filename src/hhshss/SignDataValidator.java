package hhshss;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class SignDataValidator
{
  private JFrame frame;
  private JTextField textField;
  private JTextArea textArea;
  private JButton btnValidate;
  
  public static void main(String[] args)
  {
		boolean isSigned=false;
		try {
			String base64EncodedData="ew0KICAicmdkdGxzIjogew0KICAgICJhcGx0eSI6ICJBUExSRyIsDQogICAgImFwbHN0IjogIkFQUFIiLA0KICAgICJzdGNkIjogIjA4Ig0KICB9LA0KICAiYXJuIjogIkFBMDgwMzE3MDAwMDM2USIsDQogICJvcmlnaGFzaCI6ICI2ZjNkNGM5ODIwYWQ1MzQ5N2JjZDcwNmI5ZWZlZGNkZGNhOWYyMDc4NTM5OTUxYzk4NDdmNzcxZGZkYzQ4OGIwIiwNCiAgInRvZHRscyI6IHsNCiAgICAidG9ubSI6ICJBQ0VTIFRlc3QyODMiLA0KICAgICJ0b2RnIjogIkpvaW50IENvbW1pc3Npb25lciIsDQogICAgInBsIjogIk11bWJhaSIsDQogICAgImR0IjogIjE3LTA2LTIwMTciDQogIH0NCn0=";
			 String dscSignedData="MIAGCSqGSIb3DQEHAqCAMIACAQExCzAJBgUrDgMCGgUAMIAGCSqGSIb3DQEHAaCAJIAEggG4ZXcwS0lDQWljbWRrZEd4eklqb2dldzBLSUNBZ0lDSmhjR3gwZVNJNklDSkJVRXhTUnlJc0RRb2dJQ0FnSW1Gd2JITjBJam9nSWtGUVVGSWlMQTBLSUNBZ0lDSnpkR05rSWpvZ0lqQTRJZzBLSUNCOUxBMEtJQ0FpWVhKdUlqb2dJa0ZCTURnd016RTNNREF3TURNMlVTSXNEUW9nSUNKdmNtbG5hR0Z6YUNJNklDSTJaak5rTkdNNU9ESXdZV1ExTXpRNU4ySmpaRGN3Tm1JNVpXWmxaR05rWkdOaE9XWXlNRGM0TlRNNU9UVXhZems0TkRkbU56Y3haR1prWXpRNE9HSXdJaXdOQ2lBZ0luUnZaSFJzY3lJNklIc05DaUFnSUNBaWRHOXViU0k2SUNKQlEwVlRJRlJsYzNReU9ETWlMQTBLSUNBZ0lDSjBiMlJuSWpvZ0lrcHZhVzUwSUVOdmJXMXBjM05wYjI1bGNpSXNEUW9nSUNBZ0luQnNJam9nSWsxMWJXSmhhU0lzRFFvZ0lDQWdJbVIwSWpvZ0lqRTNMVEEyTFRJd01UY2lEUW9nSUgwTkNuMD0AAAAAAACggDCCBREwggP5oAMCAQICBHc1mOowDQYJKoZIhvcNAQELBQAwgYMxCzAJBgNVBAYTAklOMRgwFgYDVQQKEw9lTXVkaHJhIExpbWl0ZWQxHTAbBgNVBAsTFENlcnRpZnlpbmcgQXV0aG9yaXR5MTswOQYDVQQDEzJlLU11ZGhyYSBTdWIgQ0EgZm9yIENsYXNzIDIgR29sZCBPcmdhbmlzYXRpb24gMjAxNDAeFw0xNjA5MTIwNzQyNTZaFw0xODA5MTIwNzQyNTZaMIGfMQswCQYDVQQGEwJJTjENMAsGA1UECgwEdGVzdDENMAsGA1UECwwEdGVzdDETMBEGA1UEAwwKQUFHRlQwODUzTDFJMEcGA1UEBRNANmUyYzJlNTAwOTVkZjM4NDYzZjE4ZDFhNTJhNjkxZDcxMzNlZTA3N2I0ZTE1MjBmOTE2MmYyOTYwZjA3YTlhMjESMBAGA1UECAwJa2FybmF0YWthMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuSXnKZdNPXKPgaze7c20vhbXXfz46RB0d-Ks_SVp03iXLXLAaHxRWVX12IOJlOTRPBjw8n3Ij363fsPqH2gm10sAN3Srn0XxEMQA5icn2X4ty40nRVLF_sMCDhLA1N9MVZsjW8SM25p86Q5hn6IgtnKhAOg0uc5omYrddrskfs0UIOzHaHuxW4S9K9rI85GfPMljzZsMvBbEKJDgiuXhbFBtDqixJtJjJsnv-krCG0HU_05TXo6o0L_VXf3RH79HPYxjIZ6BeQO4mnZfQeqb65LP31zCGg2WG_l_9yEvftQUVugB781ZwIzq8DBxaiMSb_ZrdLLgnsYM509Sf_KNYwIDAQABo4IBbTCCAWkwHQYDVR0lBBYwFAYIKwYBBQUHAwQGCCsGAQUFBwMCMB0GA1UdDgQWBBT92ejUMzhyGMgr36TzWFBxY0O-jjByBgNVHSAEazBpMC0GBmCCZGQCAjAjMCEGCCsGAQUFBwICMBUaE0NsYXNzIDIgQ2VydGlmaWNhdGUwOAYHYIJkZAEIAjAtMCsGCCsGAQUFBwIBFh9odHRwOi8vd3d3LmUtbXVkaHJhLmNvbS90ZXN0Y3BzMBMGA1UdIwQMMAqACEXIuPdh46C5ME4GCCsGAQUFBwEBBEIwQDA-BggrBgEFBQcwAoYyaHR0cDovLzExNS4yNDYuOTkuMTMzL3JlcG9zaXRvcnkvY2FjZXJ0cy9jMm9yZy5jcnQwDgYDVR0PAQH_BAQDAgbAMEAGA1UdHwQ5MDcwNaAzoDGGL2h0dHA6Ly8xMTkuODIuMTI1LjExNC9yZXBvc2l0b3J5L2NybHMvYzJvcmcuY3JsMA0GCSqGSIb3DQEBCwUAA4IBAQBxIrYfUYGAGKb5_El4QdT-FipebwW9vlHpIJbNogfmw4OHQpc5teAtuHkzacLEOelS2_4qLzs1r_YHDkGwFq4s7M4jgAbX6Ly3_NE3Tcte5BpfBumwNrJc6TIgFlWDbKmYGD2nyeMZYuRiMQ8fLDNggflC7IxxtbtM_PnG9wmLUgnHU0tYBHbSH9n17skAWjaLkvaw3j6NlorfeUSqohijnPknCdNsQD7-M3M59EoSVlafQZTs1ypSJoX9s5jOwEGMYIAfwZAFhRe2RFD3tAqLXusSoLBAztd96rRkfuuvuoLZVpg6VPV2mldGaE8u1US6k09U1i__UU2kJusonnSIAAAxggITMIICDwIBATCBjDCBgzELMAkGA1UEBhMCSU4xGDAWBgNVBAoTD2VNdWRocmEgTGltaXRlZDEdMBsGA1UECxMUQ2VydGlmeWluZyBBdXRob3JpdHkxOzA5BgNVBAMTMmUtTXVkaHJhIFN1YiBDQSBmb3IgQ2xhc3MgMiBHb2xkIE9yZ2FuaXNhdGlvbiAyMDE0AgR3NZjqMAkGBSsOAwIaBQCgXTAYBgkqhkiG9w0BCQMxCwYJKoZIhvcNAQcBMBwGCSqGSIb3DQEJBTEPFw0xNzA2MjAxMDQ5NDZaMCMGCSqGSIb3DQEJBDEWBBQx5bbYzvt3OfZnZdVCWfVEJec0JDANBgkqhkiG9w0BAQEFAASCAQCwm_McF9vtyNaVnBlSc-eFtRRTFAVtibWduhMEYS3ajvvwCP2BIWNQld-JE7ShQOcI2n1uy9IbYjc-wbuKubsz12LsX8cDfemKiw9nmaKeGaw6nvkYr4UVNqUUEfcoiqbZESIVYCa60ziByiID_FkNzICrluH-rgwPH2cQX5Ve9c_oqRLplsLLNezn9fGodqeYTqacHkOn5nheA62-LF1dzKbCsOA31y3DShTpvy9pmP3alvfSZ7WZmqfs9mU6j69_n0Bnsf-8Ho758WCiKxpJIW1MhZIPdXOYy4LZoMB7cMkml3-mssv2fpHim1LUzHavGK3dTq2qkTQ8SJxFV4b5AAAAAAAA";
			isSigned = SignDataVerificationUtil.verifySign_nsdl(base64EncodedData, dscSignedData);
			System.out.println("issigned:"+isSigned);
		} catch (Exception e) {
			e.printStackTrace();;
		}
	  
	  
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          SignDataValidator window = new SignDataValidator();
          window.frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public SignDataValidator()
  {
    initialize();
  }
  
  private void initialize()
  {
    this.frame = new JFrame();
    this.frame.setBounds(100, 100, 700, 400);
    this.frame.setResizable(false);
    this.frame.setDefaultCloseOperation(3);
    this.frame.getContentPane().setLayout(null);
    this.frame.setTitle("Sign Data Validator");
    URL titleImageURL = getClass().getResource("logo_without_text.png");
    Image titleImage = new ImageIcon(titleImageURL).getImage();
    this.frame.setIconImage(titleImage);
    
    JPanel panel = new JPanel();
    panel.setBounds(10, 11, 664, 360);
    this.frame.getContentPane().add(panel);
    panel.setLayout(null);
    
    JLabel lblData = new JLabel("Data");
    lblData.setBounds(10, 14, 61, 14);
    panel.add(lblData);
    
    this.textField = new JTextField();
    this.textField.setBounds(68, 11, 580, 20);
    panel.add(this.textField);
    this.textField.setColumns(10);
    
    JLabel lblSign = new JLabel("Sign");
    lblSign.setBounds(10, 39, 54, 85);
    panel.add(lblSign);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(68, 39, 580, 85);
    panel.add(scrollPane);
    
    this.textArea = new JTextArea();
    scrollPane.setViewportView(this.textArea);
    
    this.btnValidate = new JButton("Validate");
    this.btnValidate.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        boolean isSigned = false;boolean isExceptionOccured = false;
        String callResult = "";String exceptionOccured = "";
        int resultType = -1;
        String base64EncodedData = SignDataValidator.this.textField.getText();
        String dscSignedData = SignDataValidator.this.textArea.getText();
        try
        {
          isSigned = SignDataVerificationUtil.verifySign_nsdl(base64EncodedData, dscSignedData);
        }
        catch (Exception e1)
        {
          isExceptionOccured = true;
          exceptionOccured = e1.getMessage();
          e1.printStackTrace();
        }
        callResult = String.valueOf(isSigned);
        resultType = 1;
        if (isExceptionOccured)
        {
          callResult = exceptionOccured;
          resultType = 0;
        }
        JOptionPane.showMessageDialog(null, ": " + callResult, "Validation Result", resultType);
      }
    });
    this.btnValidate.setBounds(233, 135, 166, 23);
    panel.add(this.btnValidate);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(10, 166, 638, 2);
    panel.add(separator);
    
    StringBuilder sBudNote = new StringBuilder();
    sBudNote.append("<html>");
    sBudNote.append("<p>*Note &nbsp;: Returning 'true' from this utility is prerequisite for filing GSTR.</p>");
    sBudNote.append("<p>For GSTR1</p>");
    sBudNote.append("<p><code>Data : SHA-256(Base64(Raw JSON Summary))</code></p>");
    sBudNote.append("<p><code>Sign : Sign(Data)</code></p>");
    sBudNote.append("<p>For GSTR3b</p>");
    sBudNote.append("<p><code>Data : SHA-256(SHA-256(PARTA)+SHA-256(PARTB))</code></p>");
    sBudNote.append("<p><code>Sign : Sign(Data)</code></p>");
    sBudNote.append("</html>");
    JLabel lblNewLabel = new JLabel();
    lblNewLabel.setBounds(10, 169, 638, 125);
    panel.add(lblNewLabel);
    lblNewLabel.setText(sBudNote.toString());
    
    URL labelImageURL = getClass().getResource("logo_with_text.png");
    Image labelImage = new ImageIcon(labelImageURL).getImage();
    JLabel lblNewLabel_1 = new JLabel(new ImageIcon(labelImage), 4);
    panel.add(lblNewLabel_1);
    
    JSeparator separator_1 = new JSeparator();
    separator_1.setBounds(10, 305, 638, 2);
    panel.add(separator_1);
  }
}

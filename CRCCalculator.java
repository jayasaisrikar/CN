import java.util.Scanner;

public class CRCCalculator {
 
  // Define the polynomial values for each CRC type
  private static final int CRC_POLY = 0x1021;
  private static final int CRC12_POLY = 0x80F;
  private static final int CRC16_POLY = 0x8005;
  private static final int CRC18_POLY = 0x1021D;
  private static final int CRCIP_POLY = 0x4C11DB7;
 
  public static void main(String[] args) {
   
    // Get user input for data set
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter data set: ");
    String data = scanner.nextLine();
   
    // Get user input for CRC type
    System.out.println("Select CRC type:");
    System.out.println("1. crc");
    System.out.println("2. crc12");
    System.out.println("3. crc16");
    System.out.println("4. crc18");
    System.out.println("5. crcip");
    System.out.print("Enter selection: ");
    int selection = scanner.nextInt();
   
    // Calculate CRC based on user input
    int crc = 0;
    switch (selection) {
      case 1:
        crc = calculateCRC(data, CRC_POLY);
        break;
      case 2:
        crc = calculateCRC(data, CRC12_POLY);
        break;
      case 3:
        crc = calculateCRC(data, CRC16_POLY);
        break;
      case 4:
        crc = calculateCRC(data, CRC18_POLY);
        break;
      case 5:
        crc = calculateCRC(data, CRCIP_POLY);
        break;
      default:
        System.out.println("Invalid selection");
        System.exit(0);
    }
   
    // Print the calculated CRC
    System.out.println("CRC: " + crc);
   
  }
 
  // Calculates the CRC for a given data set and polynomial
  private static int calculateCRC(String data, int poly) {
   
    int crc = 0;
   
    // Loop through each character in the data set
    for (int i = 0; i < data.length(); i++) {
        
      // XOR the current byte with the CRC value
      crc ^= (data.charAt(i) << 8);
    
      // Loop through each bit in the current byte
      for (int j = 0; j < 8; j++) {
       
        // If the most significant bit is 1, shift the CRC and XOR with the polynomial
        if ((crc & 0x8000) != 0) {
          crc = ((crc << 1) ^ poly);
        } else {
          crc <<= 1;
        }
       
      }
     
    }
   
    return crc;
   
  }
 
}

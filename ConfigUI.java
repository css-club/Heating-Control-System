css.heatingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UserConfigUI {
    private JFrame frame;
    private final Map<String, String> parameters;
    private JLabel centralDisplayLabel; // Label to display content in the central panel
    private static final String CONFIG_FILE = "config.properties";

    public UserConfigUI() {
        parameters = new HashMap<>();
        loadParameters();
        initializeUI();
    }

    private void initializeUI() {
        // Create the main frame
        frame = new JFrame("Heating Control System");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLayout(new BorderLayout(10, 10));

        // Add a blue background to the frame
        frame.getContentPane().setBackground(new Color(173, 216, 230));

        // Add a window listener for custom exit behavior
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleExit();
            }
        });

        // Create a list of menu options (remove exit option)
        String[] menuOptions = {
                "1. Set Time Period",
                "2. Set Heating Mode",
                "3. Set Indoor Temperature",
                "4. Set Presence Temperature",
                "5. Set Away Temperature",
                "6. Set Inside Time",
                "7. Set Away Time",
                "8. View Configuration"
        };

        // Create the menu list
        JList<String> menuList = new JList<>(menuOptions);
        menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuList.setBorder(BorderFactory.createTitledBorder("Menu"));
        menuList.setFixedCellHeight(30);
        menuList.setFixedCellWidth(170);
        menuList.setBackground(new Color(135, 206, 250));
        menuList.setForeground(Color.BLACK);
        menuList.setFont(new Font("Arial", Font.BOLD, 12));

        // Add a listener to the menu list for handling item clicks
        menuList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selected = menuList.getSelectedValue();
                handleMenuSelection(selected);
            }
        });

        // Add the menu list to a scroll pane
        JScrollPane scrollPane = new JScrollPane(menuList);

        // Add the scroll pane to the west of the frame
        frame.add(scrollPane, BorderLayout.WEST);

        // Add a central panel for displaying information
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(224, 255, 255));
        centralDisplayLabel = new JLabel("<html><h2>Welcome to the Configuration System</h2></html>", SwingConstants.CENTER);
        centralDisplayLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(centralDisplayLabel, BorderLayout.CENTER);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Create a panel for the buttons with GridBagLayout
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(new Color(173, 216, 230));

        // Define the GridBagConstraints for button positioning
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Help button
        JButton helpButton = new JButton("Help");
        helpButton.setPreferredSize(new Dimension(80, 30)); // Make the help button smaller
        helpButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "To configure the system, select an option from the menu and follow the prompts."));
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(helpButton, gbc);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(80, 30)); // Make the exit button smaller
        exitButton.addActionListener(e -> handleExit());
        gbc.gridx = 1;
        buttonPanel.add(exitButton, gbc);

        // Add the button panel to the bottom of the frame
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }

    private void handleMenuSelection(String selected) {
        // Increase the font size for the central label when a menu item is selected
        Font largerFont = new Font("Arial", Font.BOLD, 20);
        Font normalFont = new Font("Arial", Font.BOLD, 16);

        switch (selected) {
            case "1. Set Time Period":
                centralDisplayLabel.setFont(largerFont);
                centralDisplayLabel.setText("<html><h3>Set Time Period</h3><p>Please configure the time period.</p></html>");
                setTimePeriod();
                break;
            case "2. Set Heating Mode":
                centralDisplayLabel.setFont(largerFont);
                centralDisplayLabel.setText("<html><h3>Set Heating Mode</h3><p>Select the heating mode you want.</p></html>");
                setHeatingMode();
                break;
            case "3. Set Indoor Temperature":
                centralDisplayLabel.setFont(largerFont);
                centralDisplayLabel.setText("<html><h3>Set Indoor Temperature</h3><p>Configure the indoor temperature.</p></html>");
                setTemperature();
                break;
            case "4. Set Presence Temperature":
                centralDisplayLabel.setFont(largerFont);
                centralDisplayLabel.setText("<html><h3>Set Presence Temperature</h3><p>Set the temperature for when you are present.</p></html>");
                setPresenceTemp();
                break;
            case "5. Set Away Temperature":
                centralDisplayLabel.setFont(largerFont);
                centralDisplayLabel.setText("<html><h3>Set Away Temperature</h3><p>Set the temperature for when you are away.</p></html>");
                setAwayTemp();
                break;
            case "6. Set Inside Time":
                centralDisplayLabel.setFont(largerFont);
                centralDisplayLabel.setText("<html><h3>Set Inside Time</h3><p>Configure the time before presence settings activate.</p></html>");
                setInsideTime();
                break;
            case "7. Set Away Time":
                centralDisplayLabel.setFont(largerFont);
                centralDisplayLabel.setText("<html><h3>Set Away Time</h3><p>Configure the time before away settings activate.</p></html>");
                setAwayTime();
                break;
            case "8. View Configuration":
                centralDisplayLabel.setFont(largerFont);
                centralDisplayLabel.setText("<html><h3>View Configuration</h3><p>Here are your current settings:</p></html>");
                viewConfiguration();
                break;
            default:
                centralDisplayLabel.setFont(normalFont);
                centralDisplayLabel.setText("<html><h3>Invalid Selection</h3><p>Please choose a valid option.</p></html>");
        }
    }

    private void handleExit() {
        int option = JOptionPane.showConfirmDialog(frame, "Do you want to save changes before exiting?", "Confirm Exit", JOptionPane.YES_NO_CANCEL_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            saveParameters();
            System.exit(0);
        } else if (option == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        // Cancel option does nothing
    }

    private void loadParameters() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            props.load(input);
            props.stringPropertyNames().forEach((key) -> {
                parameters.put(key, props.getProperty(key));
            });
        } catch (IOException e) {
            // File not found or other issues, start with empty parameters
            System.out.println("No configuration file found, starting fresh.");
        }
    }

    private void saveParameters() {
        Properties props = new Properties();
        props.putAll(parameters);
        try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
            props.store(output, "User Configuration");
            System.out.println("Configuration saved successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving configuration: " + e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setTimePeriod() {
        String timePeriod = JOptionPane.showInputDialog(frame, "Enter time period (e.g., 08:00-12:00):");
        if (timePeriod != null && timePeriod.matches("\\d{2}:\\d{2}-\\d{2}:\\d{2}")) {
            parameters.put("Time Period", timePeriod);
            JOptionPane.showMessageDialog(frame, "Time Period successfully updated.");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid time period. Use format HH:MM-HH:MM.");
        }
    }

    private void setHeatingMode() {
        String[] modes = {"Auto", "Manual"};
        String heatingMode = (String) JOptionPane.showInputDialog(
                frame,
                "Select heating mode:",
                "Heating Mode",
                JOptionPane.QUESTION_MESSAGE,
                null,
                modes,
                modes[0]
        );
        if (heatingMode != null) {
            parameters.put("Heating Mode", heatingMode);
            JOptionPane.showMessageDialog(frame, "Heating Mode successfully updated.");
        }
    }

    private void setTemperature() {
        String tempStr = JOptionPane.showInputDialog(frame, "Enter indoor temperature (10-35°C):");
        try {
            if (tempStr != null) {
                double temperature = Double.parseDouble(tempStr);
                if (temperature >= 10 && temperature <= 35) {
                    parameters.put("Indoor Temperature", String.format("%.1f°C", temperature));
                    JOptionPane.showMessageDialog(frame, "Indoor temperature successfully updated.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Temperature must be between 10 and 35°C.");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid temperature. Please enter a valid number.");
        }
    }

    private void setPresenceTemp() {
        String tempStr = JOptionPane.showInputDialog(frame, "Enter presence temperature (10-35°C):");
        try {
            if (tempStr != null) {
                double temperature = Double.parseDouble(tempStr);
                if (temperature >= 10 && temperature <= 35) {
                    parameters.put("Presence Temperature", String.format("%.1f°C", temperature));
                    JOptionPane.showMessageDialog(frame, "Presence temperature successfully updated.");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid temperature. Please enter a valid number.");
        }
    }

    private void setAwayTemp() {
        String tempStr = JOptionPane.showInputDialog(frame, "Enter away temperature (10-35°C):");
        try {
            if (tempStr != null) {
                double temperature = Double.parseDouble(tempStr);
                if (temperature >= 10 && temperature <= 35) {
                    parameters.put("Away Temperature", String.format("%.1f°C", temperature));
                    JOptionPane.showMessageDialog(frame, "Away temperature successfully updated.");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid temperature. Please enter a valid number.");
        }
    }

    private void setInsideTime() {
        String timeStr = JOptionPane.showInputDialog(frame, "Enter inside time (in minutes):");
        try {
            if (timeStr != null) {
                int minutes = Integer.parseInt(timeStr);
                if (minutes > 0) {
                    parameters.put("Inside Time", minutes + " minutes");
                    JOptionPane.showMessageDialog(frame, "Inside time successfully updated.");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid time. Please enter a valid number.");
        }
    }

    private void setAwayTime() {
        String timeStr = JOptionPane.showInputDialog(frame, "Enter away time (in minutes):");
        try {
            if (timeStr != null) {
                int minutes = Integer.parseInt(timeStr);
                if (minutes > 0) {
                    parameters.put("Away Time", minutes + " minutes");
                    JOptionPane.showMessageDialog(frame, "Away time successfully updated.");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid time. Please enter a valid number.");
        }
    }

    private void viewConfiguration() {
        StringBuilder config = new StringBuilder("<html><h3>Current Configuration:</h3>");
        parameters.entrySet().forEach((entry) -> {
            config.append("<p>").append(entry.getKey()).append(": ").append(entry.getValue()).append("</p>");
        });
        config.append("</html>");
        centralDisplayLabel.setText(config.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserConfigUI::new);
    }
}

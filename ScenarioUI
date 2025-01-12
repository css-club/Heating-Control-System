package com.mycompany.heating_control_system;

import javax.swing.*;
import java.awt.*;

public class ScenarioUI {

    private final RoomConfigManager roomConfigManager;
    private final WindowManager windowManager;
    private final EventManager eventManager;
    private final Room room;
    private final RainSensor rainSensor;
    private final PresenceSensor presenceSensor;
    private final TemperatureSensor temperatureSensor;
    private JFrame frame;
    private JLabel centralDisplayLabel;

    public ScenarioUI() {
        roomConfigManager = new RoomConfigManager();
        windowManager = new WindowManager();
        eventManager = new EventManager(windowManager, roomConfigManager);
        room = new Room(20, 18); // Température actuelle et cible
        temperatureSensor = new TemperatureSensor(18.0);
        rainSensor = new RainSensor(false);
        presenceSensor = new PresenceSensor(false);
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Heating Control System - Scenario Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(new Color(173, 216, 230));

        String[] menuOptions = {
            "Simulate Scenario 1", "Simulate Scenario 2", "Simulate Scenario 3", 
            "Simulate Scenario 4", "Simulate Scenario 5", "Simulate Scenario 6", 
            "Simulate Scenario 7"
        };

        JList<String> menuList = new JList<>(menuOptions);
        menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuList.setBorder(BorderFactory.createTitledBorder("Scenarios"));
        menuList.setFixedCellHeight(30);
        menuList.setFixedCellWidth(200);
        menuList.setBackground(new Color(135, 206, 250));
        menuList.setForeground(Color.BLACK);
        menuList.setFont(new Font("Arial", Font.BOLD, 12));

        menuList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selected = menuList.getSelectedValue();
                handleScenarioSelection(selected);
            }
        });

        JScrollPane scrollPane = new JScrollPane(menuList);
        frame.add(scrollPane, BorderLayout.WEST);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(224, 255, 255));
        centralDisplayLabel = new JLabel("<html><h2>Welcome to the Heating Control System</h2></html>", SwingConstants.CENTER);
        centralDisplayLabel.setFont(new Font("Arial", Font.BOLD, 25));
        mainPanel.add(centralDisplayLabel, BorderLayout.CENTER);
        frame.add(mainPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton helpButton = new JButton("Help");
        helpButton.setPreferredSize(new Dimension(80, 35));
        helpButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Select a scenario to simulate."));
        buttonPanel.add(helpButton, gbc);

        gbc.gridx = 1;
        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(80, 35));
        exitButton.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton, gbc);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void handleScenarioSelection(String selected) {
        String result = "";
        Font largerFont = new Font("Arial", Font.BOLD, 20);

        switch (selected) {
            case "Simulate Scenario 1":
                roomConfigManager.setPresenceTemp(21);
                roomConfigManager.setAwayTemp(15);
                result = "Parameters updated successfully!";
                break;

            case "Simulate Scenario 2":
                presenceSensor.setPersonInside(true);
                room.setPresenceSwitch(true);
                presenceSensor.setPersonInside(false);
                room.setPresenceSwitch(false);
                result = "The temperature remains at the presence value.";
                break;

            case "Simulate Scenario 3":
                room.setTargetTemp((int) roomConfigManager.getAwayTemp());
                result = "Room empty for a long time. Temperature set to away value.";
                break;

            case "Simulate Scenario 4":
                rainSensor.setRaining(true);
                eventManager.handleEvent("rain");
                result = "Window tilted due to rain.";
                break;

            case "Simulate Scenario 5":
                temperatureSensor.setCurrentTemperature(30);
                eventManager.handleEvent("temperaturethreshold");
                result = "Boiler adjusted for high temperature.";
                break;

            case "Simulate Scenario 6":
                windowManager.openWindow();
                windowManager.closeWindow();
                windowManager.tiltWindow();
                result = "Window opened, closed, and tilted.";
                break;

            case "Simulate Scenario 7":
                windowManager.resetWindowState();
                result = "Window state reset.";
                break;
        }

        centralDisplayLabel.setFont(largerFont);
        centralDisplayLabel.setText("<html><h3>" + selected + "</h3><p>" + result + "</p></html>");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScenarioUI::new);
    }
}


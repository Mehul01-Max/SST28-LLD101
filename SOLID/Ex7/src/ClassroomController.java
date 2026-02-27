public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) {
        this.reg = reg;
    }

    public void startClass() {
        Projector pj = reg.getFirstOfType(Projector.class);
        pj.powerOn();
        pj.connectInput("HDMI-1");

        ISetBrightness lights = reg.getFirstOfType(ISetBrightness.class);
        lights.setBrightness(60);

        ISetTemperature ac = reg.getFirstOfType(ISetTemperature.class);
        ac.setTemperatureC(24);

        IScanAttendance scan = reg.getFirstOfType(IScanAttendance.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getFirstOfType(Projector.class).powerOff();
        reg.getFirstOfType(LightsPanel.class).powerOff();
        reg.getFirstOfType(AirConditioner.class).powerOff();
    }
}

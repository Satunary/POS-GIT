using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab16
{
    internal class ApiModelMotorcycle
    {
    }

    public record Motorcycle
    {
        public string Make { get; init; }
        public string Model { get; init; }
        public string Year { get; init; }
        public string Type { get; init; }
        public string Displacement { get; init; }
        public string Engine { get; init; }
        public string Power { get; init; }
        public string Torque { get; init; }
        public string BoreStroke { get; init; }
        public string ValvesPerCylinder { get; init; }
        public string FuelSystem { get; init; }
        public string FuelControl { get; init; }
        public string Ignition { get; init; }
        public string Lubrication { get; init; }
        public string Cooling { get; init; }
        public string Gearbox { get; init; }
        public string Transmission { get; init; }
        public string Clutch { get; init; }
        public string FuelConsumption { get; init; }
        public string Emission { get; init; }
        public string Frame { get; init; }
        public string FrontSuspension { get; init; }
        public string FrontWheelTravel { get; init; }
        public string RearSuspension { get; init; }
        public string RearWheelTravel { get; init; }
        public string FrontBrakes { get; init; }
        public string RearBrakes { get; init; }
        public string DryWeight { get; init; }
        public string SeatHeight { get; init; }
        public string GroundClearance { get; init; }
        public string Wheelbase { get; init; }
        public string FuelCapacity { get; init; }
        public string Starter { get; init; }
    }
}

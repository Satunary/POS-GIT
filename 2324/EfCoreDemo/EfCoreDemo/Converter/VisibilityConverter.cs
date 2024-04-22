using EfCoreDemoV2.Model;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EfCoreDemo2.Converter;

/// <summary>
/// Zeigt das Gendericon an, wenn der Gendername des übergebenen Gender Objekt gleich dem
/// Parameter ist.
/// </summary>
public class GenderIconVisibilityConverter : IValueConverter
{
    public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
    {
        Gender? actualValue = value as Gender;
        string visibleValue = parameter?.ToString() ?? "";
        return actualValue?.Name == visibleValue ? true : false;
    }

    public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
    {
        throw new NotImplementedException();
    }
}

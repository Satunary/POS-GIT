using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;
using Microsoft.UI.Xaml;
using CommunityToolkit.Mvvm.ComponentModel;
using System.Xml.Linq;
using CommunityToolkit.Mvvm.Input;

namespace ClockSample;
/* die folgende Klasse stellt die aktuelle Zeit so zur Verfügung, dass
 * sie als Quelle einer MAUI - Datenbindung genutzt werden kann.
 *   - Es wurde INotifyPropertyChanged implementiert damit
 *     das Ziel der Datenbindung Änderungsevents erhält
 *   - Ein im Konstruktor gestarteter Timer sorgt für die laufende
 *     Aktualisierung der unter NotifyingDateTime bereitgestellten Zeit
 */





// CommunityToolkit.Mvvm
// https://learn.microsoft.com/en-us/dotnet/communitytoolkit/mvvm/observableobject
public class NotifyingDateTime : ObservableObject {

    private DateTime _now;
    private DispatcherTimer timer;

    public NotifyingDateTime()
    {
        Now = DateTime.Now;

        // Use a timer with 100ms
        timer = new DispatcherTimer();
        timer.Interval = TimeSpan.FromMilliseconds(100);
        timer.Tick += Timer_Tick;
        timer.Start();
    }

    private void Timer_Tick(object? sender, object e)
    {
        Now = DateTime.Now;  // Update Now with current time
    }

    public DateTime Now
    {
        get => _now;
        set => SetProperty(ref _now, value);
    }
    public IRelayCommand StopCount => new RelayCommand(Stop);
    public void Stop()
    {
        timer.Stop();
    }

    public IRelayCommand StartCount => new RelayCommand(Start);

    public void Start()
    {
        timer.Start();
    }
}


// CommunityToolkit.Mvvm
// https://learn.microsoft.com/en-us/dotnet/communitytoolkit/mvvm/generators/observableproperty
public partial class NotifyingDateTimeToolkit : ObservableObject {

    [ObservableProperty]
    private DateTime _now;

    public NotifyingDateTimeToolkit()
    {
        Now = DateTime.Now;

        // Use a timer with 100ms
        DispatcherTimer timer = new DispatcherTimer();
        timer.Interval = TimeSpan.FromMilliseconds(100);
        timer.Tick += Timer_Tick;
        timer.Start();
    }

    private void Timer_Tick(object? sender, object e)
    {
        Now = DateTime.Now;  // Update Now with current time
    }

}


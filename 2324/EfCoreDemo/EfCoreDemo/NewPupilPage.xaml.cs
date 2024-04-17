using EfCoreDemoV2.ViewModels;

namespace EfCoreDemo;

public partial class NewPupilPage : ContentPage
{
	/*public NewPupilPage()
	{
		InitializeComponent();
	}*/
    public NewPupilPage(MainViewModel mvm)
    {
        InitializeComponent();
        BindingContext = mvm;
    }
}
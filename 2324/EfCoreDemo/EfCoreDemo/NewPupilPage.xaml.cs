using EfCoreDemoV2.ViewModels;

namespace EfCoreDemo2;

public partial class NewPupilPage : ContentPage
{
	
    public NewPupilPage()
    {
        InitializeComponent();
        BindingContext = MainViewModel.Instance;
    }
}

using EfCoreDemoV2.ViewModels;

namespace EfCoreDemoV2;

public partial class MainPage : ContentPage {
    private MainViewModel _viewModel;

    public MainPage()
    {
        InitializeComponent();
        BindingContext = _viewModel;

        Loaded += MainPage_Loaded;

    }
    private void MainPage_Loaded(object? sender, EventArgs e)
    {

    }

    private void CollectionView_SelectionChanged(object sender, SelectionChangedEventArgs e)
    {

    }

}

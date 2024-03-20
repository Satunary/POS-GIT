namespace Lab16
{
    public partial class MainPage : ContentPage
    {

        public MainPage()
        {
            InitializeComponent();
            BindingContext = new MotorcycleViewModel();            
        }
    }

}

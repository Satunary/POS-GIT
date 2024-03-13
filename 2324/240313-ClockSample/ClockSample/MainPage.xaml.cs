namespace ClockSample {
    public partial class MainPage : ContentPage {
       

        public MainPage()
        {
            InitializeComponent();
            // Choose one:
            BindingContext = new NotifyingDateTime();
            //BindingContext = new NotifyingDateTimeSetProperty();
            //BindingContext = new NotifyingDateTimeToolkit();
        }

        private void OnCounterClicked(object sender, EventArgs e)
        {

            ((NotifyingDateTime)BindingContext).Stop();
        }
    }

}

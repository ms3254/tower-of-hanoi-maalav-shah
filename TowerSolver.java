
public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        //System.out.println("Height is " + model.getHeight());
        // Call the missing solve method (not this one)
        System.out.println("Solving:");
        solve(model, model.height(), 0,1,2);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)

    public void solve(TowerModel model, int n, int source, int temp, int dest){
        if (n==1){
            model.move(source, dest);
            return;
        } else {
            solve(model,n-1, source, temp, dest);
            model.move(source, dest);
            solve(model,n-1, temp, dest, source);
        }
        //model.move(source, destination);
        model.print();
        System.out.println("Solved?");
    }

}

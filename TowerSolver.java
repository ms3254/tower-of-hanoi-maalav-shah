
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
        System.out.println("Recursion step: Moving " + n + " disks from " + source + " to " + dest + " (via " + temp + ")");
        if (n==1){
            System.out.println("Base case: Moving disk from " + source + " to " + dest);
            model.move(source, dest);
            model.print();
            return;
        } else {
            System.out.println("Step 1: Moving " + (n-1) + " disks from " + source + " to " + temp + " (via " + dest + ")");
            solve(model,n-1, source, dest, temp);
            System.out.println("Step 2: Moving disk " + n + " from " + source + " to " + dest);
            model.move(source, dest);
            model.print();
            solve(model,n-1, temp, source, dest);
        }
        //model.move(source, destination);
        //model.print();
        //System.out.println("Solved?");
    }

}

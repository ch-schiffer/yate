int fakultaet(int x) {
    if (x > 1) {
        return x * fakultaet(x - 1);
    } else {
        return 1;
    }
}

def fakultaet(x):
    if x > 1:
        return x * fakultaet(x - 1)
    else:
        return 1
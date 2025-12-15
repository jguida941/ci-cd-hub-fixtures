from python_failing import mathops


def test_add():
    assert mathops.add(2, 3) == 5


def test_subtract():
    # Intentional failure
    assert mathops.subtract(5, 2) == 4

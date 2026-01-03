import sys
from pathlib import Path

# Add src to path for testing
sys.path.insert(0, str(Path(__file__).parent.parent / "src"))

from srclayoutlib import get_layout, multiply

def test_layout():
    assert get_layout() == "src-layout"

def test_multiply():
    assert multiply(3, 4) == 12
